package com.blaze.fashionBlog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String Firstname;
    private String Lastname;
    private String email;
    private String password;









}
