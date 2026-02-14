package com.javatechie.jwtapplication.controller;

import com.javatechie.jwtapplication.DTOs.AuthResponse;
import com.javatechie.jwtapplication.DTOs.LoginRequest;
import com.javatechie.jwtapplication.DTOs.RegisterRequest;
import com.javatechie.jwtapplication.model.User;
import com.javatechie.jwtapplication.repositories.UserRepository;
import com.javatechie.jwtapplication.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Get user from DB
            User user = userRepository.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Generate JWT token using username
            String token = jwtService.generateToken(user.getUsername());

            // Return token, type, username, role
            return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getRole()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Invalid username or password\"}");
        }
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {

        Optional<User> existingUser = userRepository.findByUsername(registerRequest.getUsername());

        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Username already exists\"}");
        }

        // Create new user
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEnabled(true);
        user.setRole("ROLE_USER"); // default role
        userRepository.save(user);

        // Generate JWT token
        String token = jwtService.generateToken(user.getUsername());

        // Return token, type, username, role
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AuthResponse(token, user.getUsername(), user.getRole()));
    }
    // ---------------- LOGOUT ----------------
    // Optional: You can implement JWT blacklist to invalidate tokens
    // Example endpoint
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            // Save token to blacklist repository (to invalidate it)
            // jwtBlacklistRepository.save(new BlacklistedToken(token));
        }
        return ResponseEntity.ok("{\"message\": \"Logged out successfully\"}");
    }
}
