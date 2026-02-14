package com.javatechie.onetooneexample.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@Entity
@Data
@ALLArgsConstr
public class Employee {
    private Long id;
    private String name;
    private Address address;
}
