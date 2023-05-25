package com.example.churchmanagement.dto.request;

import lombok.Data;

@Data
public class PastorVerificationRequest {
    private String emailAddress;
   private String password;
    private String token;
}
