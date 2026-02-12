//package com.javatechie.demo4;
//
//import com.javatechie.demo4.Employee;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class MainApp {
//
//    public static void main(String[] args) {
//
//
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//
//        Employee emp = (Employee) context.getBean("employee");
//        Employee emp2 = (Employee) context.getBean("employee");
//        System.out.println(emp);
//
//        System.out.println(emp2);
//
//        Employee emp3 = (Employee) context.getBean("employee2");
//        Employee emp4 = (Employee) context.getBean("employee2");
//        System.out.println(emp3);
//        System.out.println(emp4);
//
//        System.out.println("Employee ID: " + emp.getId());
//        System.out.println("Employee Name: " + emp.getName());
//        System.out.println("Employee Salary: " + emp.getSalary());
//
//    }

//}


//package com.javatechie.demo4;
//
//import com.javatechie.demo4.Employee;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class MainApp {
//
//    public static void main(String[] args) {
//
//
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//
//        Employee emp = (Employee) context.getBean("employee");
//        Employee emp2 = (Employee) context.getBean("employee");
//        System.out.println(emp);
//
//        System.out.println(emp2);
//
//        Employee emp3 = (Employee) context.getBean("employee2");
//        Employee emp4 = (Employee) context.getBean("employee2");
//        System.out.println(emp3);
//        System.out.println(emp4);
//
//        System.out.println("Employee ID: " + emp.getId());
//        System.out.println("Employee Name: " + emp.getName());
//        System.out.println("Employee Salary: " + emp.getSalary());
//
//    }

//}

package com.javatechie.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//
//        Employee e1 = context.getBean(Employee.class);
//        Employee e2 = context.getBean(Employee.class);

//        System.out.println(e1 == e2);// true → singleton, false → prototype
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Employee e1 = context.getBean(Employee.class);
        Employee e2 = context.getBean(Employee.class);

        System.out.println(e1 == e2);

    }
}


