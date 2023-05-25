package com.example.churchmanagement.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String firstName;
    private String lastName;

    private String phoneNumber;

    private String emailAddress;

    private String profile_picture;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;



    private Role role = Role.ADMIN;
}
