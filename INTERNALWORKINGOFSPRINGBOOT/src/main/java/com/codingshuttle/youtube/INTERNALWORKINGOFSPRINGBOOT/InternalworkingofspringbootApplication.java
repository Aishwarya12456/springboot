package com.codingshuttle.youtube.INTERNALWORKINGOFSPRINGBOOT;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalworkingofspringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternalworkingofspringbootApplication.class, args);
	}
	private  RazarpayPaymentservices paymentservices=new RazarpayPaymentservices();

	@Override
	public void run(String... args) throws Exception {
		String payment=paymentservices.pay();
		System.out.println("Payment done:"+payment);
	}
}
