package com.example.jip2022_w5.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jip2022_w5.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username,String password);
}
