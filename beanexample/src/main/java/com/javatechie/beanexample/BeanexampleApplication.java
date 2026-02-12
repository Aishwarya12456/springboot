package com.javatechie.beanexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanexampleApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(BeanexampleApplication.class, args);
        AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Payment payment=Context.getBean(Payment.class);
//        System.out.println(payment.getProvideName());
//        Payment payment=Context.getBean("payment1",Payment.class);
//        System.out.println(payment.getProvideName());
        Payment paypalbean=Context.getBean("paypalbean",Payment.class);
        System.out.println(paypalbean.getProvideName());
        Payment paytmbean=Context.getBean("paytmbean",Payment.class);
        System.out.println(paytmbean.getProvideName());



        String name=Context.getBean(String.class);
        System.out.println(name);

    }

}
