package com.example.jip2022_w5.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;
    private String email;
    private Date birthday;
    private int sexsmall;
    private boolean enabled;


    @OneToOne(mappedBy = "user")
    private Authorities authorities;


}
