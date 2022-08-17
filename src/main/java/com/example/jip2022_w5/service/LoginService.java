package com.example.jip2022_w5.service;

import com.example.jip2022_w5.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserService userService;

    public boolean validateUser(String userid, String password) {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(userid) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}