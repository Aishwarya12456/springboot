package com.javatechie.templateintegration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homecontroller {
    @GetMapping({"/home","","/"})
    public String showhomepage(Model model){
        model.addAttribute("title","home");

        return "master";

    }

    @GetMapping({"/signup"})
    public String showsignuppage(Model model){
        model.addAttribute("title","signup");
        return "master";

    }
    @GetMapping({"/login"})
    public String showloginpage(Model model){
        model.addAttribute("title","login");
        return "master";

    }
}
