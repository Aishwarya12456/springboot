package com.javatechie.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Customer {
    private String name = "BUSHAN";
    @Autowired
//    @Qualifier("payment3")
    private Payment payment3;


    public Customer( @Qualifier("payment3")
                     Payment payment)
    {
        this.payment3=payment;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Payment getPayment() {
        return payment3;
    }

    public void setPayment(Payment payment) {
        this.payment3 = payment;
    }
}
