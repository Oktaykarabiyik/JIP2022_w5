package com.example.jip2022_w5.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Data
public class Authorities {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username",nullable = false)
    @JsonIgnore
    User user;

    private String authority;

}
