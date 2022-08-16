package com.example.jip2022_w5.controllers;


import com.example.jip2022_w5.entities.User;
import com.example.jip2022_w5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

        @Autowired
        private UserRepository userRepository;


        @GetMapping
        public List<User> getAllUsers(){
           return  userRepository.findAll();
        }

        @PostMapping
        public User createUser(@RequestBody User newUser){
            return userRepository.save(newUser);
        }

        @GetMapping("/{userId}")
        public User getOneUser(@PathVariable Long userId){

            return userRepository.findById(userId).orElse(null);

        }


}
