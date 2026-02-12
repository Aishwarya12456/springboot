package com.javatechie.jdbctemplate.repository;


import com.javatechie.jdbctemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(User user) {
        String sql = "INSERT INTO users(full_name, email, password, phone, gender, hobbies, country, dob) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFullName(), user.getEmail(), user.getPassword(), user.getPhone(), user.getGender(), user.getHobbies(), user.getCountry(), user.getDob());
    }
}