package com.example.churchmanagement.serviceIMPL;

import ch.qos.logback.core.model.Model;
import com.example.churchmanagement.ToolZ;
import com.example.churchmanagement.data.model.Pastor;
import com.example.churchmanagement.data.repository.PastorRepository;
import com.example.churchmanagement.dto.request.PastorRequest;
import com.example.churchmanagement.dto.request.PastorVerificationRequest;
import com.example.churchmanagement.dto.response.PastorResponse;
import com.example.churchmanagement.dto.response.PastorVerificationResponse;
import com.example.churchmanagement.exception.*;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.service.PastorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
@RequiredArgsConstructor
@Service
public class PastorServiceIMPL implements PastorService {
    @NonNull
   private final ChurchService churchService;
    @NonNull
    private final  PastorRepository pastorRepository;
    @NonNull
    private final ToolZ toolz;




    @Override
    public PastorResponse RegisterNewPastorAccount(PastorRequest pastorRequest1){
        Pastor buildPastor = mapFromRequestToPastor(pastorRequest1);
        toolz.passwordValidator(buildPastor.getPassword());
        confirmIfEmailAddressAlreadyExist(buildPastor.getEmailAddress());
        confirmIfPhoneAlreadyExist(buildPastor.getPhoneNumber());
        String token = tokenCreator(buildPastor);
       //toolZ.registrationEmailSender(buildPastor,token);
     //  buildPastor.setToken(token);

        return new PastorResponse("registration completed successfully please log on to your confirmation site to verify your account");
    }

    @Override
    public boolean emailAlreadyInUsed(String email) {
     if (pastorRepository.findByEmailAddress(email) == null) return true;
     return false;
    }

    String boneshaker = "gold";
    @Override
    public long countChurchMenber() {
        return pastorRepository.count();
    }
    private Pastor temDataBaseFindByEmailAddress(String emailAddress) {

        return null;
    }

    @Override
    public PastorVerificationResponse verifyPastorAccount(PastorVerificationRequest verifyRequest) throws RegistrationVerificationException {
        Pastor foundPastor = temDataBaseFindByEmailAddress(verifyRequest.getEmailAddress());
        verificationValidation(foundPastor, verifyRequest);
//        if (! foundPastor.getToken().equals(verifyRequest.getToken())){
//            throw new RegistrationVerificationException("invalid token");
//        }
        pastorRepository.save(foundPastor);
        return new PastorVerificationResponse("Registration completed successfully");
    }
    private void verificationValidation(Pastor foundPastor,PastorVerificationRequest verifyRequest) throws RegistrationVerificationException {
        if (foundPastor == null) {
            throw new RegistrationVerificationException("account does not exist");
        }
        if (!foundPastor.getPassword().equals(verifyRequest.getPassword())){
            throw new RegistrationVerificationException("invalid password");
        }
    }


    private Pastor mapFromRequestToPastor(PastorRequest pastorRequest){
        return Pastor.builder().
        firstName(pastorRequest.getFirstName()).
        lastName(pastorRequest.getLastName())
        .emailAddress(pastorRequest.getEmailAddress()).
        address(pastorRequest.getAddress())
        .phoneNumber(pastorRequest.getPhoneNumber()).
        gender(pastorRequest.getGender()).Profile_picture
        (pastorRequest.getProfile_picture()).password(pastorRequest.getPassword()).build();
    }
    private void confirmIfEmailAddressAlreadyExist(String emailAddress) throws RegistrationException {
    Pastor pastor  = pastorRepository.findByEmailAddress(emailAddress);
    if (pastor != null)
        throw new RegistrationException("Email address already exists "+emailAddress);
    }
    private void confirmIfPhoneAlreadyExist(String phoneNumber) throws RegistrationException {
        Pastor pastor = pastorRepository.findByPhoneNumber(phoneNumber);
        if (pastor != null) throw new RegistrationException("Phone number already exists  "+phoneNumber);
    }
    private static   String tokenCreator(Pastor pastor){
       String cutFirst = pastor.getFirstName();
        StringBuilder stringBuilder = new StringBuilder(cutFirst);
    int token = secureRandom.nextInt(7000000,7999999);
    String stringToken = String.valueOf(token);
    String firstTwoAlphabet = stringBuilder.substring(0,2);
    return stringToken+firstTwoAlphabet;
    }



}

