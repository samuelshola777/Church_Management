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
import com.example.churchmanagement.service.EmailAlreadyInUse;
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
    @NonNull
    private final EmailAlreadyInUse emailAlreadyInUse;




    @Override
    public PastorResponse RegisterNewPastorAccount(PastorRequest pastorRequest1){
      emailAlreadyInUse.pastorEmailAlreadyInUse(pastorRequest1.getEmailAddress());
        registrationCheckIfEmailAreadyExist(pastorRequest1.getEmailAddress());
        toolz.passwordValidator(pastorRequest1.getPassword());
        toolz.phoneNumberValidator(pastorRequest1.getPhoneNumber());
    Pastor mappedPastor = mapToPastorEntity(pastorRequest1);
        return ;
    }

    public void registrationCheckIfEmailAreadyExist(String email){
    Pastor existingPastor = pastorRepository.findByEmailAddress(email);
    if(existingPastor!=null) throw new FindingExection("pastor account with email address -> "+email+" <-  already exists");
    }

    public Pastor mapToPastorEntity(PastorRequest pastorRequest){
        return Pastor.builder()
                .gender(pastorRequest.getGender())
                .password(pastorRequest.getPassword())
                .phoneNumber(pastorRequest.getPhoneNumber())
                .address(pastorRequest.getAddress())
                .Profile_picture(pastorRequest.getProfile_picture())
                .emailAddress(pastorRequest.getEmailAddress())
                .lastName(pastorRequest.getLastName())
                .firstName(pastorRequest.getFirstName())
                .churchName(pastorRequest.getChurchName())
                .build();
    }


}

