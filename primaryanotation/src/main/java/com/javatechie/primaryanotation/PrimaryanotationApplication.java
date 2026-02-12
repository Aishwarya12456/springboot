package com.javatechie.primaryanotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PrimaryanotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrimaryanotationApplication.class, args);
        AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext(AppConfig.class);
        Payment payment=Context.getBean(Payment.class);
        System.out.println(payment.getProvideName());

    String name=Context.getBean(String.class);
        System.out.println(name);

}
}
