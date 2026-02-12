package com.javatechie.autowired;

import com.javatechie.autowired.component.Customer;
import com.javatechie.autowired.component.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Autowiredapplication {

    public static void main(String[] args) {

        SpringApplication.run(Autowiredapplication.class, args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(com.javatechie.autowired.config.Appconfig.class);

        Payment payment = context.getBean(Payment.class);
        Customer customer = context.getBean(Customer.class);

        System.out.println(payment.getProviderName());
        System.out.println(customer.getName());
        System.out.println(customer.getPayment());
    }


}
