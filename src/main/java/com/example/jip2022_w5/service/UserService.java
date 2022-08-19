package com.example.jip2022_w5.service;

import com.example.jip2022_w5.entities.User;
import com.example.jip2022_w5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User getFindUser(String username, String passowrd) {
        return userRepository.findUserByUsernameAndPassword(username, passowrd);
    }

    public User getFindUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User getFindEmail(String email) {
        return userRepository.findUserByEmail(email);
    }


}
