package com.example.churchmanagement.data.model;


import com.example.churchmanagement.tokenZ.data.model.PastorTokenZ;
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
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DateZ dateOfBirth;
    private String churchName;
    private String emailAddress;
    private LocalDateTime registrationDate ;
    private ValidationState validationState;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    private String token;
    private String password;
    private String Profile_picture;
    private Role role = Role.PASTOR;
    private Gender gender;
    private int age;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private ChurchBranch churchBranch;

   
}
