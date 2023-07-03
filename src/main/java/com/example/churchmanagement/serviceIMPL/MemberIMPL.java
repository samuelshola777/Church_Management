package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.data.model.Member;
import com.example.churchmanagement.data.repository.MemberRepository;
import com.example.churchmanagement.dto.request.MemberRequest;
import com.example.churchmanagement.dto.response.MemberResponse;
import com.example.churchmanagement.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MemberIMPL implements MemberService {
private final MemberRepository memberRepository;

    @Override
    public MemberResponse memberRegistration(MemberRequest memberRequest1) {
        Member mappedMember = mapRequestToMember(memberRequest1);
        return ;
    }

    @Override
    public long countMembers() {
        return memberRepository.count();
    }
    public Member mapRequestToMember(MemberRequest memberRequest) {
        return Member.builder()
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
