package com.javatechie.jdbctemplate.service;


import com.javatechie.jdbctemplate.model.User;
import com.javatechie.jdbctemplate.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;

    public void register(User user) {
        registerRepository.createUser(user);
    }
}
