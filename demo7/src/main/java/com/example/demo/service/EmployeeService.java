package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Repository.employeedao;
import com.example.demo.Repository.employeedao;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;





@Service
public class EmployeeService {

    @Autowired
    private employeedao dao;

    public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {

        //-----------------only paging----------------------------
    	/*
    	Pageable pageable = PageRequest.of(pageNo, pageSize);
    	Page<Employee> pagedResult = dao.findAll(pageable);
    	if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
        */


        //--------------only sorting---------------------
    	/*
    	Sort sortOrder = Sort.by(sortBy);
    	List<Employee> list = new ArrayList<Employee>();

    	Iterable<Employee> it = dao.findAll(sortOrder);
    	it.forEach(employee -> {
    		list.add(employee);
    	});

    	return list;
    	*/




        //---------------paging with sorting-----------------

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> pagedResult = dao.findAll(pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }

        //return null;
    }
    public Employee saveEmployee(Employee employee) {
        System.out.println("Data Inserted");
        return dao.save(employee);
    }

    public Page<Employee> getEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        System.out.println("Get Request Sucess!");
        return dao.findAll(pageable);
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {

        Employee existingEmployee = dao.findById(id).orElse(null);

        if (existingEmployee == null) {
            return null; // employee not found
        }

        existingEmployee.setFirstName(newEmployee.getFirstName());
        existingEmployee.setLastName(newEmployee.getLastName());
        existingEmployee.setEmail(newEmployee.getEmail());

        return dao.save(existingEmployee); // UPDATE happens here
    }


    public boolean deleteEmployee(Long id) {

        if (!dao.existsById(id)) {
            return false; // employee not found
        }

        dao.deleteById(id);
        return true;
    }

}