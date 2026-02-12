package com.javatechie.jdbctemplate.controller;

import com.javatechie.jdbctemplate.model.User;   // ✅ IMPORTANT IMPORT
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.javatechie.jdbctemplate.service.RegisterService;

@Controller
@AllArgsConstructor
public class HomeController {
    private final RegisterService registerService;
    // Show register page
    @GetMapping({"/", "/home"})
    public String showhomepage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Handle form submit
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result) {
        System.out.println("printing the new user details: " + user);
        if(result.hasErrors()){
            return"register";
        }
        registerService.register(user);
        return "success";
    }
}
