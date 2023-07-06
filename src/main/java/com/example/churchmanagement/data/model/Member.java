package com.example.churchmanagement.data.model;


import com.example.churchmanagement.tokenZ.data.model.MemberToken;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private  ValidationState validationState =ValidationState.PENDING;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private DateZ dateOfBirth;
    private String password;
    private  String firstName , lastName;
    private String username;
    private LocalDateTime registrationDate;

    private String phoneNumber;
    @OneToMany( cascade = CascadeType.DETACH, mappedBy = "member", orphanRemoval = true)
    private final List<MemberToken > listOfToken= new ArrayList<>();

    private String emailAddress;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String profile_picture;
    private String token;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    @Enumerated(EnumType.STRING)
    private Role role = Role.MEMBER;
    private String occupation;
    private String churchName;
    @ManyToOne
    private ChurchBranch churchBranch;
    private String age;

}
