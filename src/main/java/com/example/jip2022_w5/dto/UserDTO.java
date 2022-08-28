package com.example.jip2022_w5.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class UserDTO {

    private long id;
    private String username;
    private String email;
    private Date birthday;
    private int sexsmall;

}
