package com.example.churchmanagement.tokenZ.service;

import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import com.example.churchmanagement.tokenZ.data.model.TokenState;
import com.example.churchmanagement.tokenZ.data.repository.ChurchTokenRepository;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class ChurchTokenService {
    @Autowired
    private ChurchTokenRepository churchTokenRepository;
private SecureRandom secureRandom = new SecureRandom();
    public String createTokenForChurchBranch(ChurchBranch churchBranch1) throws TokenException {
  int intToken =  secureRandom.nextInt(700000000,799999999);
    StringBuilder build = new StringBuilder(churchBranch1.getChurchBranchName());
    String first2 = build.substring(0,3);
    String token = String.valueOf( secureRandom)+build;
       ChurchTokenZ tokenZ = new ChurchTokenZ();
       tokenZ.setToken(token);
       tokenZ.setCreateAt(LocalDateTime.now());
        tokenZ.setTokenState(TokenState.VALID);
        tokenZ.setChurchBranch(churchBranch1);
//        tokenZ.getChurchBranch().add(churchBranch1);
        tokenZ.setExpiredAt(tokenZ.getCreateAt().plusMinutes(5));
        churchTokenRepository.save(tokenZ);

        return tokenZ.getToken();
    }

    public long countChurchToken() {
        return churchTokenRepository.count();
    }

    public void deleteAllToken() {
        churchTokenRepository.deleteAll();
    }
}
