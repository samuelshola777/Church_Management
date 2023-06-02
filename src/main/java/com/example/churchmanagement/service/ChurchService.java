package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.dto.response.ChurchResponse;
import com.example.churchmanagement.exception.FindingExection;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;

public interface ChurchService {


   void registerANewChurchBranch(ChurchRequest churchRequest2) throws PhoneNumberException, PasswordException, RegistrationException, TokenException;
   ChurchBranch findChurchByName(String churchName) throws RegistrationException;

   void deleteAllChurchBranch();

   ChurchBranch findChurchBranchByEmailAddress(String emailAddress) throws FindingExection;

   ChurchBranch findChurchBranchByEmail(String email);

   long tempoRepoCountChurchBranch();

   String changeChurchBranchName(String mail, String strongTowerMinistry);
}
