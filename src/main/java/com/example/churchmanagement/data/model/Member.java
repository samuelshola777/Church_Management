package com.example.churchmanagement.data.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private  String firstName , lastName;

    private String phoneNumber;

    private String emailAddress;

    private String profile_picture;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    private Role role = Role.MEMBER;
    private String occupation;
    @ManyToOne
    private ChurchBranch churchBranch;

}
