package com.example.churchmanagement.service;

import com.example.churchmanagement.dto.request.MemberRequest;
import com.example.churchmanagement.dto.response.MemberResponse;

public interface MemberService {


   MemberResponse memberRegistration(MemberRequest memberRequest1);

    long countMembers();
}
