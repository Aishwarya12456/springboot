package com.javatechie.example1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthcontroller {
    @GetMapping("/")
    public String welcome(){
        return "welcome to taskmanager api";
    }
    @GetMapping("/health")
    public String health(){
        return "application is running";
    }

}
