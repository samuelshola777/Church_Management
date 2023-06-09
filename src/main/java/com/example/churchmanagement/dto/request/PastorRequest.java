package com.example.churchmanagement.dto.request;

import com.example.churchmanagement.data.model.*;
import com.example.churchmanagement.tokenZ.data.model.PastorTokenZ;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PastorRequest {
    private  String firstName , lastName;
    private long id;
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
    private DateZ dateOfBirth;
    private PastorTokenZ pastorTokenZ;

}
