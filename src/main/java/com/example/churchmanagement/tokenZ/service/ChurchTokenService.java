package com.example.churchmanagement.tokenZ.service;

import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import com.example.churchmanagement.tokenZ.data.model.TokenState;
import com.example.churchmanagement.tokenZ.data.repository.ChurchTokenRepository;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ChurchTokenService {

    private  ChurchTokenRepository churchTokenRepository;

    public ChurchTokenZ createTokenForChurchBranch(String name) throws TokenException {
     SecureRandom secureRandom = new SecureRandom();
  int intToken =  secureRandom.nextInt(700000000,799999999);
    StringBuilder build = new StringBuilder(name);
    String first2 = build.substring(0,3);
    String token = String.valueOf(secureRandom)+build;
       ChurchTokenZ tokenZ = new ChurchTokenZ();
        System.out.println(token);
       tokenZ.setToken(token);
       tokenZ.setCreateAt(LocalDateTime.now());
        tokenZ.setTokenState(TokenState.VALID);
        tokenZ.setExpiredAt(tokenZ.getCreateAt().plusMinutes(5));
       // churchTokenRepository.save(tokenZ);
        return tokenZ;
    }



    public long countChurchToken() {
        return churchTokenRepository.count();
    }

    public void deleteAllToken() {
        churchTokenRepository.deleteAll();
    }
}
