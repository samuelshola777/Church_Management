package com.example.churchmanagement.dto.request;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PastorRequest {
    private  String firstName , lastName;

    private String phoneNumber;

    private String emailAddress;


    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    private String Profile_picture;
    private Gender gender;
    private String password;
    private String token;
}
