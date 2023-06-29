package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Address;
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
private Address address1;
private MemberRequest memberRequest2;
private Address address2;
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

    memberRequest1 = new MemberRequest();
    memberRequest1.setFirstName("temilorun");
    memberRequest1.setLastName("ekoLagos");
address1 = new Address();
address1.setLocalGovernment("ilaje");
address1.setState("lagos state");
address1.setStreetName("ilaje");
address1.setHouseNumber("103");
    memberRequest1.setAddress(address1);
    memberRequest1.setOccupation("student");
    memberRequest1.setEmailAddress("temilorun01@mailinator.com");
    memberRequest1.setChurchName("strong tower");
    memberRequest1.setPhoneNumber("09089764534");

    memberRequest2 = new MemberRequest();
    memberRequest2.setFirstName("segun");
    memberRequest2.setLastName("samuel");
    memberRequest2.setChurchName("PICC");
    memberRequest2.setOccupation("business");
address2 = new Address();
address2.setHouseNumber("20");
address2.setState("lagos");
address2.setStreetName("kajola");
address2.setLocalGovernment("shomolu");
    memberRequest2.setAddress(address2);
    memberRequest2.setEmailAddress("samuelsegun02mailinator.com");
    memberRequest2.setPhoneNumber("09041830804");


    }

    @AfterEach
    void tearDown() {
    }


}