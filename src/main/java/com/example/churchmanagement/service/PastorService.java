package com.example.churchmanagement.service;

import com.example.churchmanagement.dto.request.PastorRequest;
import com.example.churchmanagement.dto.request.PastorVerificationRequest;
import com.example.churchmanagement.dto.response.PastorResponse;
import com.example.churchmanagement.dto.response.PastorVerificationResponse;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.exception.RegistrationVerificationException;

public interface PastorService {

    PastorResponse RegisterNewPastorAccount(PastorRequest pastorRequest1) throws PhoneNumberException, PasswordException, RegistrationException;

   long countChurchMenber();

   PastorVerificationResponse verifyPastorAccount(PastorVerificationRequest verifyRequest) throws RegistrationVerificationException;
}
