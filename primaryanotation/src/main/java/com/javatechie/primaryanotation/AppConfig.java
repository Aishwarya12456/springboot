package com.javatechie.primaryanotation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean()//custom name inside bean
    Payment payment(){
        Payment p=new Payment();
        p.setProvideName("paypal");
        return p;
    }
    @Bean
    Payment payment1(){
        Payment p=new Payment();
        p.setProvideName("paytm");
        return p;
    }
    @Primary
    @Bean
    Payment payment2(){
        Payment p=new Payment();
        p.setProvideName("RazorPay");
        return p;
    }

    @Bean(value="paytm")
    String name(){
        return "BUSHON";
    }
}


