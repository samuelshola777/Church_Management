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
        emailAlreadyInUse.pastorEmailAlreadyInUse(pastorRequest1.getEmailAddress());
        registrationCheckIfEmailAlreadyExist(pastorRequest1.getEmailAddress());
        toolz.passwordValidator(pastorRequest1.getPassword());
        toolz.phoneNumberValidator(pastorRequest1.getPhoneNumber());
    Pastor mappedPastor = mapToPastorEntity(pastorRequest1);
    mappedPastor.setRegistrationDate(LocalDateTime.now());
    mappedPastor.setAge(calculateAge(mappedPastor.getDateOfBirth()));
    PastorTokenZ tokenZ = tokenService.createPastorToken(mappedPastor);
    mappedPastor.setToken(tokenZ.getToken());
    //emailService.sendEmail();
PastorTokenZ savedToken =  tokenService.saveToken(tokenZ);
mappedPastor.getListOfToken().add(tokenZ);
Pastor savedPastor = pastorRepository.save(mappedPastor);
return mapToPastorResponse(mappedPastor);
    }

    @Override
    public long countPastorAccounts() {
        return pastorRepository.count();
    }

    @Override
    public PastorVerificationResponse verifyPastorAccount(PastorVerificationRequest verifyRequest) {
        return null;
    }

    @Override
    public void deleteAllPastorAccount() {
        pastorRepository.deleteAll();
    }

    @Override
    public String setPastorToLeadAChurch(String churchEmailAddress, String pastorEmail,String token) {
     Pastor foundPastor = pastorRepository.findByEmailAddress(pastorEmail);
     ChurchBranch foundChurchBranch = churchService.findChurchBranchByEmailAddress(churchEmailAddress);
     if (! foundChurchBranch.getToken().equals(token)) throw new TokenException("invalid token");
    if (!foundChurchBranch.getValidationState().equals(ValidationState.VALIDATED)) throw new ValidationException("the church account with the email => "+churchEmailAddress+" has not not been verified");
     foundPastor.setChurchBranch(foundChurchBranch);
     Pastor savedPastor = pastorRepository.save(foundPastor);
     foundChurchBranch.setPastor(savedPastor);
     churchService.saveChurchWithPastorAccount(foundChurchBranch);
     return "completed";
    }

    public void registrationCheckIfEmailAlreadyExist(String email){
    Pastor existingPastor = pastorRepository.findByEmailAddress(email);
    if(existingPastor!=null) throw new FindingExection("pastor account with email address -> "+email+" <-  already exists");
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



    public  int calculateAge(DateZ dateZ) {
        int year = Integer.parseInt(dateZ.getYear());
        int month = Integer.parseInt(dateZ.getMonth());
        int day = Integer.parseInt(dateZ.getDate());
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime birthDate = LocalDateTime.of(year, month, day, 0, 0);
     return Period.between(birthDate.toLocalDate(), currentDate.toLocalDate()).getYears();
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
}

