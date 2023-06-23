package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Pastor;
import com.example.churchmanagement.dto.request.PastorRequest;
import com.example.churchmanagement.dto.request.PastorVerificationRequest;
import com.example.churchmanagement.dto.response.PastorResponse;
import com.example.churchmanagement.dto.response.PastorVerificationResponse;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.exception.RegistrationVerificationException;
import com.example.churchmanagement.tokenZ.data.model.PastorTokenZ;

public interface PastorService {

    PastorResponse RegisterNewPastorAccount(PastorRequest pastorRequest1);




    long countPastorAccounts();


    void deleteAllPastorAccount();

    String setPastorToLeadAChurch(String churchEmailAddress,String pastorEmailAddress, String token);

    Pastor findPastorByEmailAddress(String mail);

    PastorTokenZ generatePastorToken(String mail);
}
