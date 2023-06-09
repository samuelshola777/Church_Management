package com.example.churchmanagement.service;



import com.example.churchmanagement.data.model.ValidationState;
import com.example.churchmanagement.dto.request.ChangeChurchAddressRequest;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.dto.response.ChurchResponse;
import com.example.churchmanagement.exception.FindingExection;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import com.example.churchmanagement.data.model.ChurchBranch;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChurchService {


  ChurchResponse registerANewChurchBranch(ChurchRequest churchRequest2);
   ChurchResponse findChurchByName(String churchName) ;

   void deleteAllChurchBranch();

   ChurchBranch findChurchBranchByEmailAddress(String emailAddress);

   ChurchResponse findByEmailResponse(String email);

   ChurchResponse changeChurchBranchName(String mail, String strongTowerMinistry);

  ChurchResponse changeChurchAddress(ChangeChurchAddressRequest changeChurchAddress1);

   ChurchResponse changeChurchPassword(String email, String password);

    long countAllChurchBranch();

    ChurchTokenZ tokenGenerator(String email) ;

    ChurchResponse verifyChurchAccount(String mail, String password,String token) ;

   void deleteChurchBranchByEmailAddress(String mail, String token) ;

    void checkIfInvalid(ChurchBranch churchBranch);

    void deleteChurchBranchById(long id) ;

   Page<ChurchBranch> getAllChurchBranch(int offSet, int pageSize);

    ChurchResponse forgotPassword(String mail, String token);
}
