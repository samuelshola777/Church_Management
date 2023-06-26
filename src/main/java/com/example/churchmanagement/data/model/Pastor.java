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
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany( cascade = CascadeType.DETACH, mappedBy = "pastor", orphanRemoval = true)
    private final List<PastorTokenZ> listOfToken = new ArrayList<>();

    private String churchName;
    private String emailAddress;
    private LocalDateTime registrationDate ;

    @Enumerated( EnumType.STRING)
    private ValidationState validationState;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    private String token;

    private String password;

    private String Profile_picture;

    @Enumerated( EnumType.STRING)
    private Role role = Role.PASTOR;

    @Enumerated( EnumType.STRING)
    private Gender gender;

    private int age;

    @OneToOne( cascade = CascadeType.DETACH, orphanRemoval = true)
    private ChurchBranch churchBranch;
}
