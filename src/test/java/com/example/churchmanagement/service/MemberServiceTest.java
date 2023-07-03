package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.DateZ;
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
private DateZ dateOfBirth1;
private MemberRequest memberRequest2;
private Address address2;
private DateZ dateOfBirth2;
private MemberRequest memberRequest3;
private  Address address3;
private DateZ dateOfBirth3;
private MemberRequest memberRequest4;
private Address address4;
private DateZ dateOfBirth4;
private MemberRequest memberRequest5;
private Address address5;
private DateZ dateOfBirth5;
private MemberRequest memberRequest6;
private Address address6;
private DateZ dateOfBirth6;
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

dateOfBirth1 = new DateZ();
dateOfBirth1.setYear("1992");
dateOfBirth1.setDate("04");
dateOfBirth1.setMonth("2");

    memberRequest1.setDateOfBirth(dateOfBirth1);
    memberRequest1.setAddress(address1);
    memberRequest1.setOccupation("student");
    memberRequest1.setEmailAddress("temilorun01@mailinator.com");
    memberRequest1.setChurchName("strong tower");
    memberRequest1.setPhoneNumber("09089764534");
    memberRequest1.setPassword("milAndPass243");

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

dateOfBirth2 = new DateZ();
dateOfBirth2.setMonth("4");
dateOfBirth2.setYear("1993");
dateOfBirth2.setDate("23");

    memberRequest2.setDateOfBirth(dateOfBirth2);
    memberRequest2.setAddress(address2);
    memberRequest2.setEmailAddress("samuelsegun02mailinator.com");
    memberRequest2.setPhoneNumber("09041830804");
    memberRequest2.setPassword("springRool3234");

    memberRequest3.setFirstName("favour");
    memberRequest3.setLastName("mbata");
    memberRequest3.setOccupation("student");
    memberRequest3.setChurchName("strongtower");
    memberRequest3.setPhoneNumber("09041832334");
    memberRequest3.setPassword("babeLikeNOOther453");
address3 = new Address();
address3.setLocalGovernment("yaba");
address3.setState("lagos");
address3.setHouseNumber("901");
address3.setStreetName("hiberma");

dateOfBirth3 = new DateZ();
dateOfBirth3.setDate("7");
dateOfBirth3.setMonth("9");
dateOfBirth3.setYear("1999");

    memberRequest3.setDateOfBirth(dateOfBirth3);
    memberRequest3.setAddress(address3);
    memberRequest3.setEmailAddress("favourMbata03@mailinator.com");

    memberRequest4 = new MemberRequest();
    memberRequest4.setFirstName("adewunmi");
    memberRequest4.setLastName("adegunwa");
    memberRequest4.setPassword("specialBride156");
    memberRequest4.setPassword("09078906523");

address4 = new Address();
address4.setLocalGovernment("palmGroove");
address4.setStreetName("churchStreet");
address4.setHouseNumber("20");
address4.setState("lagos");

dateOfBirth4 = new DateZ();
dateOfBirth4.setMonth("2");
dateOfBirth4.setYear("1996");
dateOfBirth4.setDate("5");

    memberRequest4.setDateOfBirth(dateOfBirth4);
    memberRequest4.setAddress(address4);
    memberRequest4.setEmailAddress("adewunmi04@mailinator.com");
    memberRequest4.setChurchName("jehovahnessi");
    memberRequest4.setOccupation("software engineer");

    memberRequest5 = new MemberRequest();
    memberRequest5.setFirstName("samuel");
    memberRequest5.setLastName("shola");
    memberRequest5.setOccupation("software Engineer");
    memberRequest5.setPassword("coconut^673");

dateOfBirth5 = new DateZ();
dateOfBirth5.setDate("14");
dateOfBirth5.setMonth("06");
dateOfBirth5.setYear("1996");

address5 = new Address();
address5.setState("lagos");
address5.setHouseNumber("20");
address5.setLocalGovernment("bariga");
address5.setStreetName("kajola");
    memberRequest5.setAddress(address5);
    memberRequest5.setDateOfBirth(dateOfBirth5);
    memberRequest5.setChurchName("strong tower");
    memberRequest5.setEmailAddress("samuelshola05@mailinator.com");
    memberRequest5.setPhoneNumber("09099332737");

    memberRequest6 = new MemberRequest();
    memberRequest6.setFirstName("bruce");
    memberRequest6.setLastName("chirock");
    memberRequest6.setPassword("drumStick436");
    memberRequest6.setOccupation("creativity");
address6 = new Address();
address6.setStreetName("shobande");
address6.setHouseNumber("27");
address6.setState("lagos state");
address6.setLocalGovernment("akoka");
dateOfBirth6 = new DateZ();
dateOfBirth6.setYear("2000");
dateOfBirth6.setMonth("5");
dateOfBirth6.setDate("22");
    memberRequest6.setAddress(address6);
    memberRequest6.setDateOfBirth(dateOfBirth6);
    memberRequest6.setEmailAddress("chirockBruce@06@mailinator.com");
    memberRequest6.setPhoneNumber("090947938290");
    memberRequest6.setChurchName("Strong tower");

    }

    @AfterEach
    void tearDown() {
    }


}