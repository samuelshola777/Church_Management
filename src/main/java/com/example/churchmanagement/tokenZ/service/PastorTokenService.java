package com.example.churchmanagement.tokenZ.service;

import com.example.churchmanagement.data.model.Pastor;
import com.example.churchmanagement.tokenZ.data.model.PastorTokenZ;
import com.example.churchmanagement.tokenZ.data.repository.PastorTokenRepository;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Transactional
public class PastorTokenService {
@NonNull
PastorTokenRepository pastorTokenRepository;


public PastorTokenZ createPastorToken(Pastor pastor){
    SecureRandom secureRandom = new SecureRandom();
    int tokenNumber = secureRandom.nextInt(60000,69999);
    StringBuilder tokenString = new StringBuilder(pastor.getFirstName());
    String lastFour = tokenString.substring(0,4);
    String completeToken = String.valueOf(tokenNumber)+ lastFour;
    PastorTokenZ token = new PastorTokenZ();
    token.setToken(completeToken);
    token.setCreateAt(LocalDateTime.now());
    token.setPastor(pastor);
    token.setExpiredAt(token.getCreateAt().plusMinutes(30));
return pastorTokenRepository.save(token);
}

}
