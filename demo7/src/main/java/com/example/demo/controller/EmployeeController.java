//EmployeeController.java
package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //http://localhost:9090/employees?pageNo=1&pageSize=5&sortBy=empName
    //http://localhost:9090/employees?pageSize=5&sortBy=empName
    //http://localhost:9090/employees?pageNo=1&sortBy=empName
    //http://localhost:9090/employees?pageNo=1&pageSize=5
    //http://localhost:9090/employees?pageNo=1
    //http://localhost:9090/employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(
            @RequestParam(defaultValue="0", required = false) Integer pageNo,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(defaultValue = "id", required = false) String sortBy)
    {
        List<Employee> list = service.getAllEmployees(pageNo, pageSize, sortBy);

        return list;
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);

    }

    @GetMapping
    public Page<Employee> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getEmployees(page, size);

    }
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {
        Employee updatedEmployee = service.updateEmployee(id, employee);
        if (updatedEmployee == null) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        return updatedEmployee;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        boolean deleted = service.deleteEmployee(id);
        if (!deleted) {
            return "Employee not found with id: " + id;
        }
        return "Employee deleted successfully";
    }
}

//http://localhost:9090/employees/1


//http://localhost:9090/employees
