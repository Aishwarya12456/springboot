package com.example.demo.services;


import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class DepartmentService {

        @Autowired
        private DepartmentRepository repo;

        // POST
        public Department saveDepartment(Department department) {
            return repo.save(department);
        }

        // ✅ GET ALL
        public List<Department> getAllDepartments() {
            return repo.findAll();
        }

        // ✅ GET BY ID (optional but important)
        public Department getDepartmentById(Long id) {
            return repo.findById(id).orElse(null);
        }
}
