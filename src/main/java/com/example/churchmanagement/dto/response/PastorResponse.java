package com.example.churchmanagement.dto.response;

import com.example.churchmanagement.data.model.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class PastorResponse {
    private  String firstName , lastName;
    private String phoneNumber;
    private DateZ dateOfBirth;
    private String churchName;
    private String emailAddress;
    private LocalDateTime registrationDate ;
    @Enumerated(EnumType.STRING)
    private ValidationState validationState;
    private Address address;
    private String token;
    @Enumerated(EnumType.STRING)
    private Role role = Role.PASTOR;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;


}
