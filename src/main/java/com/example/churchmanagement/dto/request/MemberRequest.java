package com.example.churchmanagement.dto.request;

import com.example.churchmanagement.data.model.*;
import com.example.churchmanagement.tokenZ.data.model.MemberToken;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class MemberRequest {
    private  String firstName , lastName;

    private String phoneNumber;

    private String emailAddress;

    private String profile_picture;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany( cascade = CascadeType.DETACH, mappedBy = "member", orphanRemoval = true)
    private List<MemberToken> listOfToken= new ArrayList<>();
    private String token;
    private String username;
    private LocalDateTime registrationDate;
    private Address address;
    private ValidationState memberValidationState = ValidationState.PENDING;

    private Role role = Role.MEMBER;
    private String occupation;
    private String churchName;
    private String password;
    private DateZ dateOfBirth;
    private ChurchBranch churchBranch;
}
