package com.javatechie.qualifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class QualifierAnnotationApplication {

    public static void main(String[] args) {

        SpringApplication.run(QualifierAnnotationApplication.class, args);
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        Customer customer=context.getBean(Customer.class);
        System.out.println(customer.getName());
        System.out.println(customer.getPayment().getProviderName());

    }

}
