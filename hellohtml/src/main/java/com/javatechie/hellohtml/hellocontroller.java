package com.javatechie.hellohtml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//
@Controller
public class hellocontroller {
    @GetMapping("/")
    public String showhelloPage(){
        return "hello";
    }
}
