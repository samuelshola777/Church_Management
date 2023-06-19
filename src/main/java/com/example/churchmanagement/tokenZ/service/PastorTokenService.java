package com.example.churchmanagement.tokenZ.service;

import com.example.churchmanagement.tokenZ.data.model.PastorTokenZ;
import com.example.churchmanagement.tokenZ.data.repository.PastorTokeRepository;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@RequiredArgsConstructor
@Service
@Transactional
public class PastorTokenService {
@NonNull
PastorTokeRepository pastorTokeRepository;


public PastorTokenZ createPastorToken(String pastorName){
    SecureRandom secureRandom = new SecureRandom();
    int tokenNumber = secureRandom.nextInt(60000,69999);
    StringBuilder tokenString = new StringBuilder(pastorName);
String lastFour = tokenString.substring(0,4);
}

}
