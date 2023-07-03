package com.example.churchmanagement.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String profile_picture;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    @Enumerated(EnumType.STRING)
    private Role role = Role.MEMBER;
    private String occupation;
    private String churchName;
    @ManyToOne
    private ChurchBranch churchBranch;

}
