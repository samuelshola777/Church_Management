package com.example.churchmanagement.data.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private DateZ dateOfBirth;
    private String password;
    private  String firstName , lastName;

    private String phoneNumber;

    private String emailAddress;

    private String profile_picture;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    private Role role = Role.MEMBER;
    private String occupation;
    private String churchName;
    @ManyToOne
    private ChurchBranch churchBranch;

}
