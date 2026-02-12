
package com.javatechie.jdbcdemo.controller;


import com.javatechie.jdbcdemo.model.User;
import com.javatechie.jdbcdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }
    @GetMapping("/")
    public String home() {
        // Redirect the home URL "/" to "/list"
        return "redirect:/list";
    }


    @GetMapping("/list")
    public String readAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/users")
    public String processUsers(@ModelAttribute User user) {
        if (user.getId() != null) {
            //UPDATE operation
            userService.updateUser(user);
        } else {
            //CREATE operation
            userService.createUser(user);
        }
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String findUserById(@PathVariable Integer id, Model model) {
        User existingUser = userService.findUserById(id);
        model.addAttribute("user", existingUser);
        return "user-form";
    }

}
