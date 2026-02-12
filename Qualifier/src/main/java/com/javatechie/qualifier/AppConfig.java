package com.javatechie.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.javatechie.qualifier")
public class AppConfig {
    @Bean
    Payment payment1(){
        Payment p=new Payment();
        p.setProviderName("Paypal");
        return p;
    }
    @Bean
//    @Primary
    Payment payment2(){
        Payment p=new Payment();
        p.setProviderName("Paytm");
        return p;
    }
    @Bean
    Payment payment3(){
        Payment p=new Payment();
        p.setProviderName("RazorPay");
        return p;
    }

}
