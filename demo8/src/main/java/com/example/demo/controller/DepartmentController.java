package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // POST
    @PostMapping
    public Department save(@RequestBody Department department) {
        return service.saveDepartment(department);
    }

    // ✅ GET ALL
    @GetMapping
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return service.getDepartmentById(id);
    }
}
