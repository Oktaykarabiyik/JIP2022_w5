package com.example.jip2022_w5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String email;
    private Date birthday;
    private int sexsmall;
    private boolean enabled;


   /* @OneToOne(mappedBy = "user")
    private Authorities authorities;*/


}
