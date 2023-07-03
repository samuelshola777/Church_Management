package com.example.churchmanagement.dto.response;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.Gender;
import com.example.churchmanagement.data.model.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;

public class MemberResponse {
    private  String firstName , lastName;

    private String phoneNumber;

    private String emailAddress;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String occupation;
    private String churchName;
}
