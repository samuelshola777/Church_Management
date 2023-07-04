package com.example.churchmanagement.tokenZ.service;

import com.example.churchmanagement.data.model.Member;
import com.example.churchmanagement.tokenZ.data.model.MemberToken;
import com.example.churchmanagement.tokenZ.data.model.PastorTokenZ;
import com.example.churchmanagement.tokenZ.data.model.TokenState;

import java.security.SecureRandom;
import java.time.LocalDateTime;

public class MemberTokenService {

    public MemberToken memberTokenGenerator(Member member){
        SecureRandom secureRandom = new SecureRandom();
        int tokenNumber = secureRandom.nextInt(11111,19999);
        StringBuilder tokenString = new StringBuilder(member.getFirstName());
        String lastFour = tokenString.substring(0,4);
        String completeToken = String.valueOf(tokenNumber)+ lastFour;
        MemberToken token = new MemberToken();
        token.setTokenState(TokenState.VALID);
        token.setToken(completeToken);
        token.setCreateAt(LocalDateTime.now());
        token.setExpiredAt(token.getCreateAt().plusMinutes(30));
        return  token;
    }

}
