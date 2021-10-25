package com.kelvin.javafxspringboot.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    public User() {
        super();
    }

    public User(Integer id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.username = username;
        this.lastName = lastName;
        this.password = password;
    }

}
