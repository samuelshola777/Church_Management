package com.example.churchmanagement.service;

import com.example.churchmanagement.dto.request.MemberRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class MemberServiceTest {
    @NonNull
    private MemberService memberService;
private MemberRequest memberRequest1;
private MemberRequest memberRequest2;
private MemberRequest memberRequest3;
private MemberRequest memberRequest4;
private MemberRequest memberRequest5;
private MemberRequest memberRequest6;
private MemberRequest memberRequest7;
private MemberRequest memberRequest8;
private MemberRequest memberRequest9;
private MemberRequest memberRequest10;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


}