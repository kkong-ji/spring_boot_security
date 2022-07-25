package com.example.security1.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import lombok.Data;
import java.sql.Timestamp;


@Entity
@Data
public class Users {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String roles;
    private String email;
    private String role; // ROLE_USER, ROLE_ADMIN
    @CreationTimestamp
    private Timestamp createDate;
}