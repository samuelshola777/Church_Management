package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.ToolZ;
import com.example.churchmanagement.data.model.*;
import com.example.churchmanagement.data.repository.PastorRepository;
import com.example.churchmanagement.dto.request.PastorRequest;
import com.example.churchmanagement.dto.request.PastorVerificationRequest;
import com.example.churchmanagement.dto.response.PastorResponse;
import com.example.churchmanagement.dto.response.PastorVerificationResponse;
import com.example.churchmanagement.emailEngine.service.EmailService;
import com.example.churchmanagement.exception.*;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.service.EmailAlreadyInUse;
import com.example.churchmanagement.service.PastorService;
import com.example.churchmanagement.tokenZ.data.model.PastorTokenZ;
import com.example.churchmanagement.tokenZ.service.PastorTokenService;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import jakarta.validation.ValidationException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;

@RequiredArgsConstructor
@Service
public class PastorServiceIMPL implements PastorService {
    @NonNull
   private final ChurchService churchService;
    @NonNull
    private final  PastorRepository pastorRepository;
    @NonNull
    private final ToolZ toolz;
    @NonNull
    private final EmailAlreadyInUse emailAlreadyInUse;
    @NonNull
    private final PastorTokenService tokenService;
    @NonNull
    private EmailService emailService;

    @Override
    public PastorResponse RegisterNewPastorAccount(PastorRequest pastorRequest1){

     if (registrationCheckIfEmailAlreadyExist(pastorRequest1.getEmailAddress())){
         Pastor upDatedPastor = completeUpdateForPastorAccount(pastorRequest1);
         upDatedPastor.setId(pastorRequest1.getId());
        toolz.phoneNumberValidator(upDatedPastor.getPhoneNumber());
        toolz.passwordValidator(upDatedPastor.getPassword());
        PastorTokenZ token = tokenService.createPastorToken(upDatedPastor);
        upDatedPastor.setToken(token.getToken());
        upDatedPastor.getListOfToken().add(token);
         token.setPastor(upDatedPastor);
//        tokenService.saveToken(token);
        return mapToPastorResponse(upDatedPastor);
     }
    if (pastorRepository.findByEmailAddress(pastorRequest1.getEmailAddress() )!= null)
        throw new FindingExection("pastor account with email address -> "+pastorRequest1.getEmailAddress()+" <-  already exists");
        emailAlreadyInUse.pastorEmailAlreadyInUse(pastorRequest1.getEmailAddress());
        registrationCheckIfEmailAlreadyExist(pastorRequest1.getEmailAddress());
        toolz.passwordValidator(pastorRequest1.getPassword());
        toolz.phoneNumberValidator(pastorRequest1.getPhoneNumber());
    Pastor mappedPastor = mapToPastorEntity(pastorRequest1);
    mappedPastor.setRegistrationDate(LocalDateTime.now());
    mappedPastor.setAge(toolz.calculateAge(mappedPastor.getDateOfBirth()));
    PastorTokenZ tokenZ = tokenService.createPastorToken(mappedPastor);
    mappedPastor.setToken(tokenZ.getToken());
    //emailService.sendEmail();
        mappedPastor.getListOfToken().add(tokenZ);
        Pastor savedPastor = pastorRepository.save(mappedPastor);
        tokenZ.setPastor(savedPastor);
        tokenService.saveToken(tokenZ);
return mapToPastorResponse(mappedPastor);
    }

    @Override
    public long countPastorAccounts() {
        return pastorRepository.count();
    }


    @Override
    public void deleteAllPastorAccount() {
        pastorRepository.deleteAll();
    }

    @Override
    public String setPastorToLeadAChurch(String churchEmailAddress, String pastorEmail,String token) {
     Pastor foundPastor = findPastorByEmailAddress(pastorEmail);
    if (foundPastor == null)throw new FindingExection("pastor's account "+pastorEmail+" does not exist");
     if (foundPastor.getValidationState() != ValidationState.VALIDATED) throw new ValidationException
         ("pastor's account has not been validated please ensure to validate your account");
     ChurchBranch foundChurchBranch = churchService.findChurchBranchByEmailAddress(churchEmailAddress);
  if (foundChurchBranch == null) throw new FindingExection("church branch with email address => "+churchEmailAddress+" <= does not exist");
     if (! foundChurchBranch.getToken().equals(token))
         throw new TokenException("invalid token");
    if (!foundChurchBranch.getValidationState().equals(ValidationState.VALIDATED)) throw new ValidationException("the church account with the email => "+churchEmailAddress+" has not not been verified");
     foundPastor.setChurchBranch(foundChurchBranch);
     Pastor savedPastor = pastorRepository.save(foundPastor);
     foundChurchBranch.setPastor(foundPastor);
     churchService.saveChurchWithPastorAccount(foundChurchBranch);

     return "completed";
    }

    @Override
    public Pastor findPastorByEmailAddress(String mail) {
        Pastor foundPastor = pastorRepository.findByEmailAddress(mail);
    if (foundPastor == null) throw new FindingExection("pastor account with the email "+mail+" does not exist");
        if (foundPastor.getValidationState() == ValidationState.INVALID) throw  new ValidationException("=> invalid pastor account <=");
        return foundPastor;
    }

    @Override
    public PastorTokenZ generatePastorToken(String mail) {
Pastor foundPastor = pastorRepository.findByEmailAddress(mail);
 PastorTokenZ tokenZ =  tokenService.createPastorToken(foundPastor);
   //emailService.sendEmail();
   foundPastor.setToken(tokenZ.getToken());

  // foundPastor.getListOfToken().add(tokenZ);
   pastorRepository.save(foundPastor);
   return tokenZ;
    }

    @Override
    public PastorResponse validatePastorAccount(String mail, String password, String token) {
    Pastor foundPastor = findPastorByEmailAddress(mail);
    if (!foundPastor.getPassword().equals(password)) throw new PasswordException("wrong password");
    if (!foundPastor.getToken().equals(token)) throw new TokenException("invalid token");
    foundPastor.setValidationState(ValidationState.VALIDATED);
    return mapToPastorResponse(pastorRepository.save(foundPastor));
    }

    @Override
    public void deletePastorAccountByEmail(String mail, String token) {
        Pastor foundPastor = findPastorByEmailAddress(mail);
    if (!token.equals(foundPastor.getToken())) throw new TokenException("invalid token");
      foundPastor.setValidationState(ValidationState.INVALID);
  // if (foundPastor.getValidationState() != ValidationState.VALIDATED) {
//ChurchBranch foundChurchBranch = churchService.findChurchBranchByEmailAddress(foundPastor.getChurchBranch().getEmailAddress());
//     foundChurchBranch.setPastor(null);
//       foundPastor.setChurchBranch(null);
//       foundPastor.setChurchName(null);
//        churchService.saveChurchWithPastorAccount(foundChurchBranch);
       pastorRepository.save(foundPastor);
  // }
    }

    @Override
    public Page<PastorResponse> getAllPastors(int page , int pageSize ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Pastor> pastorPage = pastorRepository.findAll(pageable);

    }


    public boolean registrationCheckIfEmailAlreadyExist(String email){
    Pastor existingPastor = pastorRepository.findByEmailAddress(email);
    if(existingPastor!=null && existingPastor.getValidationState() == ValidationState.INVALID) return true;
    // (existingPastor != null && existingPastor.getValidationState() != ValidationState.INVALID) throw new FindingExection("pastor account with email address -> "+email+" <-  already exists");
    return false;
    }


    public Pastor mapToPastorEntity(PastorRequest pastorRequest){
        return Pastor.builder()
                .dateOfBirth(pastorRequest.getDateOfBirth())
                .gender(pastorRequest.getGender())
                .password(pastorRequest.getPassword())
                .phoneNumber(pastorRequest.getPhoneNumber())
                .address(pastorRequest.getAddress())
                .Profile_picture(pastorRequest.getProfile_picture())
                .emailAddress(pastorRequest.getEmailAddress())
                .validationState(pastorRequest.getValidationState())
                .lastName(pastorRequest.getLastName())
                .firstName(pastorRequest.getFirstName())
                .churchName(pastorRequest.getChurchName())
                .role(pastorRequest.getRole())
                .token(pastorRequest.getToken())
                .build();
    }




    public PastorResponse mapToPastorResponse(Pastor pastor){
        return PastorResponse.builder()
              .firstName(pastor.getFirstName())
              .lastName(pastor.getLastName())
              .churchName(pastor.getChurchName())
              .phoneNumber(pastor.getPhoneNumber())
              .address(pastor.getAddress())
              .gender(pastor.getGender())
              .token(pastor.getToken())
                .role(Role.PASTOR)
              .registrationDate(pastor.getRegistrationDate())
              .build();
    }

    public Pastor completeUpdateForPastorAccount(PastorRequest pastorRequest){
        Pastor foundPastor  = pastorRepository.findByEmailAddress(pastorRequest.getEmailAddress());
    foundPastor    = Pastor.builder()
            .id(foundPastor.getId())
                .role(pastorRequest.getRole())
                 .emailAddress(pastorRequest.getEmailAddress())
                .dateOfBirth(pastorRequest.getDateOfBirth())
                .age(toolz.calculateAge(pastorRequest.getDateOfBirth()))
                .validationState(pastorRequest.getValidationState())
                .address(pastorRequest.getAddress())
                .lastName(pastorRequest.getLastName())
                .churchName(pastorRequest.getChurchName())
                .firstName(pastorRequest.getFirstName())
                .phoneNumber(pastorRequest.getPhoneNumber())
                .gender(pastorRequest.getGender())
                .Profile_picture(pastorRequest.getProfile_picture())
                .password(pastorRequest.getPassword())
                .registrationDate(LocalDateTime.now())
                .build();
pastorRepository.save(foundPastor);
return foundPastor;
    }

}

