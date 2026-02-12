package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class DropdownController {

    @GetMapping("/dropdown")
    public String showDropdown(Model model) {

        // List of values for dropdown
        List<String> countries = Arrays.asList(
                "India", "USA", "UK", "Canada"
        );

        // Send list to Thymeleaf
        model.addAttribute("countries", countries);

        return "dropdown";
    }

    @PostMapping("/submitCountry")
    public String submitCountry(@RequestParam("country") String country) {

        System.out.println("Selected country: " + country);

        return "result";
    }
}
