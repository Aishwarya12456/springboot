package com.javatechie.autowired.component;

import org.springframework.stereotype.Component;

@Component
public class Payment  {
    private String providerName="Paypal";

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    public String printHello(){return "hello...";}
    @Override
    public String toString(){
        return "Payment{"+
                "provideName='"+providerName+ '\''+
        '}';
    }

}
