package com.javatechie.jwtapplication.configs;

import com.javatechie.jwtapplication.exceptions.UnauthorizedException;
import com.javatechie.jwtapplication.repositories.JwtBlacklistRepository;
import com.javatechie.jwtapplication.security.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;

    @Autowired
    private JwtBlacklistRepository jwtBlacklistRepository;

    public JwtAuthenticationFilter(JwtUtils jwtUtils,
                                   UserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            // 1️⃣ Get JWT from Authorization header
            String jwt = parseJwt(request);

            // 2️⃣ Validate token
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {

                // 2a️⃣ Check if token is blacklisted (logged out)
                if (jwtBlacklistRepository.findByToken(jwt).isPresent()) {
                    throw new UnauthorizedException("Token has been logged out");
                }

                // 3️⃣ Extract username from token
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

                // 4️⃣ Load user details from DB
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // 5️⃣ Create authentication object
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                // 6️⃣ Set request details
                authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                // 7️⃣ Set authentication in SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (UnauthorizedException e) {
            // Token is blacklisted
            logger.warn("Unauthorized: {}", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
            return; // Stop filter chain
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        // 8️⃣ Continue filter chain
        filterChain.doFilter(request, response);
    }

    // Helper method: extract token from Authorization header
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }
}
