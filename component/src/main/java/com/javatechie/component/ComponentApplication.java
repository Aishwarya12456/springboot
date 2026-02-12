package com.javatechie.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class ComponentApplication {

    public static void main(String[] args) {

        SpringApplication.run(ComponentApplication.class, args);
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Appconfig.class);
        Payment payment=context.getBean(Payment.class);
        System.out.println(payment.printHello());
    }

}
