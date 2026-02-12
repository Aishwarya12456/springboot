package com.javatechie.onepagetoother;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {
    @GetMapping({"/home"})
    public String showhomepage(Model model){
        model.addAttribute("myname","busham");
        model.addAttribute("title","aboutus");
        return "mypage";

    }
    @GetMapping("/about-us")
    public String showaboutuspage(Model model){
        model.addAttribute("title","aboutus");
        return "aboutus";
    }
    @GetMapping("/contact-us")
    public String showcontactus(Model model){
        model.addAttribute("title","contactus");
        return "contactus";
    }
    @GetMapping("/services")
    public String showservices(Model model){
        model.addAttribute("title","services");
        return "services";
    }
}
