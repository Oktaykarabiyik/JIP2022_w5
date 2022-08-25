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

    private String authority;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;*/
    private String username;

}
