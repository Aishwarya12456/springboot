package com.javatechie.postconstructandpredestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Payment {
    private String providerName;
    public String getProviderName(){
        return  providerName;
    }

    public void setProviderName(String provideName) {
        this.providerName = providerName;
    }
    public String printHello() {
        return "Hello...";
    }
    @PostConstruct
    public  void init(){
        this.providerName="Paypal";

    }
    @PreDestroy
    public void cleanUp(){
        System.out.println("closing the database connection");
    }
}
