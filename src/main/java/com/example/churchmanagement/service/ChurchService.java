package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.dto.response.ChurchResponse;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;

public interface ChurchService {


   ChurchResponse registerANewChurchBranch(ChurchRequest churchRequest2) throws PhoneNumberException, PasswordException, RegistrationException, TokenException;
   ChurchBranch findChurchByName(String churchName) throws RegistrationException;

   void deleteAllChurchBranch();

   long tempoRepoCountChurchBranch();
}
