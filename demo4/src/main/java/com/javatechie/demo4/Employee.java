//package com.javatechie.demo4;
//
//public class employee {
//
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    private int id;
//    private String name;
//    private double salary;
//
//    public void setName(String name){
//        this.name=name;
//
//    }
//    public void setSalary(double salary){
//        this.salary=salary;
//    }
//    public int getid(){
//        return id;
//    }
//    public String getName(){
//        return  name;
//    }
//    public  double getSalary(){
//        return salary;
//    }
//
//
//}
package com.javatechie.demo4;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Employee {

    private int id;
    private String name;
    private double salary;


    public Employee() {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
