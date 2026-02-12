package com.javatechie.javaobject.controller;


import com.javatechie.javaobject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    // Show form
    @GetMapping("/user")
    public String showForm(Model model) {

        // Empty object for form binding
        model.addAttribute("user", new User());

        return "user-form";
    }

    // Handle form submit
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Age: " + user.getAge());

        return "success";
    }
}
