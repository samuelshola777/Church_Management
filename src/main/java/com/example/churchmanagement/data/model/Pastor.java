package com.example.churchmanagement.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
public class Pastor {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        private Long id;

    private  String firstName , lastName;
    private String phoneNumber;
    private String churchName;
    private String emailAddress;
    private LocalDateTime registrationDate ;
    private ValidationState validationState;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    private String password;
    private String Profile_picture;
    private Role role = Role.PASTOR;
    private Gender gender;
    private int age;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private ChurchBranch churchBranch;

   
}
