package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.DateZ;
import com.example.churchmanagement.data.model.Gender;
import com.example.churchmanagement.dto.request.MemberRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
private Address address7;
private DateZ dateOfBirth7;
private MemberRequest memberRequest8;
private Address address8;
private DateZ dateOfBirth8;
private MemberRequest memberRequest9;
private Address address9;
private DateZ dateOfBirth9;
private MemberRequest memberRequest10;
private Address address10;
private DateZ dateOfBirth10;


    @BeforeEach
    void setUp() {

    memberRequest1 = new MemberRequest();
    memberRequest1.setFirstName("temilorun");
    memberRequest1.setLastName("ekoLagos");
    memberRequest1.setGender(Gender.FEMALE);
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
    memberRequest2.setGender(Gender.MALE);
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
    memberRequest3.setGender(Gender.FEMALE);
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
    memberRequest4.setGender(Gender.FEMALE);

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
    memberRequest5.setGender(Gender.MALE);
    memberRequest5.setEmailAddress("samuelshola05@mailinator.com");
    memberRequest5.setPhoneNumber("09099332737");

    memberRequest6 = new MemberRequest();
    memberRequest6.setFirstName("bruce");
    memberRequest6.setLastName("chirock");
    memberRequest6.setPassword("drumStick436");
    memberRequest6.setOccupation("creativity");
    memberRequest6.setGender(Gender.MALE);
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

    memberRequest7 = new MemberRequest();
    memberRequest7.setFirstName("ajaye");
    memberRequest7.setLastName("alfred");
    memberRequest7.setOccupation("driver");
    memberRequest7.setChurchName("PICC");

address7 = new Address();
address7.setLocalGovernment("akoka");
address7.setHouseNumber("12");
address7.setState("lagos");
address7.setStreetName("downCommunityRoad");

dateOfBirth7 = new DateZ();
dateOfBirth7.setDate("15");
dateOfBirth7.setMonth("02");
dateOfBirth7.setYear("1995");

    memberRequest7.setAddress(address7);
    memberRequest7.setDateOfBirth(dateOfBirth7);
    memberRequest7.setPassword("StickTogether5647");
    memberRequest7.setEmailAddress("alfredAjaye07@mailinator.com");
    memberRequest7.setPhoneNumber("090947938290");
    memberRequest7.setGender(Gender.MALE);

    memberRequest8 = new MemberRequest();
    memberRequest8.setFirstName("sheymiloray");
    memberRequest8.setLastName("badmous");
    memberRequest8.setOccupation("Buisness");
    memberRequest8.setChurchName("Discovery center");
    memberRequest8.setPhoneNumber("09094799290");

address8 = new Address();
address8.setLocalGovernment("akoka");
address8.setHouseNumber("190");
address8.setStreetName("jolaosho");
address8.setState("lagos");

dateOfBirth8 = new DateZ();
dateOfBirth8.setMonth("1");
dateOfBirth8.setYear("1995");
dateOfBirth8.setDate("13");

    memberRequest8.setAddress(address8);
    memberRequest8.setDateOfBirth(dateOfBirth8);
    memberRequest8.setEmailAddress("shaymiloray08@mailinator.com");
    memberRequest8.setGender(Gender.FEMALE);
    memberRequest8.setPassword("ArtandLife326");

    memberRequest9 = new MemberRequest();
    memberRequest9.setFirstName("bukola");
    memberRequest9.setLastName("gloryOfGod");
    memberRequest9.setGender(Gender.FEMALE);
    memberRequest9.setOccupation("student");
    memberRequest9.setPassword("ChristOurKing759");

address9 = new Address();
address9.setState("lagost");
address9.setHouseNumber("B67");
address9.setStreetName("FCE");
address9.setLocalGovernment("akoka");

dateOfBirth9 = new DateZ();
dateOfBirth9.setYear("2001");
dateOfBirth9.setMonth("03");
dateOfBirth9.setDate("24");

    memberRequest9.setAddress(address9);
    memberRequest9.setDateOfBirth(dateOfBirth9);
    memberRequest9.setPhoneNumber("07089428843");
    memberRequest9.setEmailAddress("bukolaGloryOfGod09@mailinator.com");

    memberRequest10 = new MemberRequest();
    memberRequest10.setFirstName("john");
    memberRequest10.setLastName("only01");
    memberRequest10.setPhoneNumber("07080702920");
    memberRequest10.setGender(Gender.MALE);
    memberRequest10.setPassword("letTheGuitarLead090");
    memberRequest10.setOccupation("student");
    memberRequest10.setChurchName("StrongTower");

address10 = new Address();
address10.setLocalGovernment("akoka");
address10.setState("lagos");
address10.setHouseNumber("B67");
address10.setLocalGovernment("bajulaye");

dateOfBirth10 = new DateZ();
dateOfBirth10.setDate("7");
dateOfBirth10.setYear("2000");
dateOfBirth10.setMonth("03");

        memberRequest10.setAddress(address10);
        memberRequest10.setDateOfBirth(dateOfBirth10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatMemberRegisterAndCreateAccount(){
     assertNotNull(   memberService.memberRegistration(memberRequest1));
     assertNotNull(   memberService.memberRegistration(memberRequest2));
     assertNotNull(   memberService.memberRegistration(memberRequest3));
     assertNotNull(   memberService.memberRegistration(memberRequest4));
     assertNotNull(   memberService.memberRegistration(memberRequest5));
     assertNotNull(   memberService.memberRegistration(memberRequest6));
     assertNotNull(   memberService.memberRegistration(memberRequest7));
     assertNotNull(   memberService.memberRegistration(memberRequest8));
     assertNotNull(   memberService.memberRegistration(memberRequest9));
     assertNotNull(   memberService.memberRegistration(memberRequest10));

  assertEquals(10, memberService.countMembers());
    }


}