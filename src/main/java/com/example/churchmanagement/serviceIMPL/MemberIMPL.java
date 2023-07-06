package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.ToolZ;
import com.example.churchmanagement.data.model.Member;
import com.example.churchmanagement.data.repository.MemberRepository;
import com.example.churchmanagement.dto.request.MemberRequest;
import com.example.churchmanagement.dto.response.MemberResponse;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.service.MemberService;
import com.example.churchmanagement.tokenZ.service.MemberTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberIMPL implements MemberService {
private final MemberRepository memberRepository;
private final ToolZ tool;
private final MemberTokenService tokenService;



    @Override
    public MemberResponse memberRegistration(MemberRequest memberRequest1) {
        registrationIfAccountWithEmailAllReadyExist(memberRequest1.getEmailAddress());
        tool.passwordValidator(memberRequest1.getPassword());
        tool.phoneNumberValidator(memberRequest1.getPhoneNumber());
        Member mappedMember = mapRequestToMember(memberRequest1);
        mappedMember.setRegistrationDate(LocalDateTime.now());
        mappedMember.setAge(String.valueOf(tool.calculateAge(mappedMember.getDateOfBirth())));



        return null ;
    }


    private void registrationIfAccountWithEmailAllReadyExist(String emailAddress) {
      Member foundMember = memberRepository.findByEmailAddress( emailAddress);
      if (foundMember != null ) throw new RegistrationException
      ("Account with email address " + emailAddress+" already exists");
    }

    @Override
    public long countMembers() {
        return memberRepository.count();
    }
    public Member mapRequestToMember(MemberRequest memberRequest) {
        return Member.builder()
                .registrationDate(memberRequest.getRegistrationDate())
                .username(memberRequest.getUsername())
                .token(memberRequest.getToken())
                .listOfToken(memberRequest.getListOfToken())
                .address(memberRequest.getAddress())
                .gender(memberRequest.getGender())
                .churchBranch(memberRequest.getChurchBranch())
                .churchName(memberRequest.getChurchName())
                .firstName(memberRequest.getFirstName())
                .lastName(memberRequest.getLastName())
                .emailAddress(memberRequest.getEmailAddress())
                .password(memberRequest.getPassword())
                .occupation(memberRequest.getOccupation())
                .role(memberRequest.getRole())
                .dateOfBirth(memberRequest.getDateOfBirth())
                .phoneNumber(memberRequest.getPhoneNumber())
                .profile_picture(memberRequest.getProfile_picture())
                .build();
    }

}
