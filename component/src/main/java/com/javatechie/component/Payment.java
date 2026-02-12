package com.javatechie.component;

import org.springframework.stereotype.Component;

@Component
public class Payment {
    private String provideName;
    public String getProvideName(){
        return  provideName;
    }

    public void setProvideName(String provideName) {
        this.provideName = provideName;
    }
    public String printHello(){
        return "Hello...";
    }
}
