package com.javatechie.jdbcdemo.service;


import com.javatechie.jdbcdemo.model.User;
import com.javatechie.jdbcdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }


    public void createUser(User user) {

        userRepository.createUser(user);
    }

    public void deleteUser(Integer id) {

        userRepository.deleteUser(id);
    }

    public User findUserById(Integer id) {

        return userRepository.findUserById(id);
    }

    public void updateUser(User user) {

        userRepository.update(user);
    }
}