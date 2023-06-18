package com.example.churchmanagement.dto.request;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.Gender;
import com.example.churchmanagement.data.model.Role;
import com.example.churchmanagement.data.model.ValidationState;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PastorRequest {
    private  String firstName , lastName;

    private String phoneNumber;
    private String churchName;
    private String emailAddress;
    private Role role = Role.PASTOR;
    private ValidationState validationState = ValidationState.PENDING;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    private String Profile_picture;
    private Gender gender;
    private String password;
    private String token;
}
