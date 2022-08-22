package com.example.jip2022_w5.repository;


import com.example.jip2022_w5.entities.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jip2022_w5.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username,String password);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
