package com.javatechie.beanexample;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

       @Bean(name="paypal") //custom names  inside brackets
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
       @Bean(value="paytm")
       String name(){
           return "BUSHON";
       }
   }


