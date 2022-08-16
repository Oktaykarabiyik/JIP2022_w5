package com.example.jip2022_w5.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
@Data
public class Authorities {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String authority;

}
