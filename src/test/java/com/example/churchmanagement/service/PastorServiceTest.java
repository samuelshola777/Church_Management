package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.DateZ;
import com.example.churchmanagement.data.model.Gender;
import com.example.churchmanagement.data.model.Pastor;
import com.example.churchmanagement.dto.request.PastorRequest;
import com.example.churchmanagement.dto.request.PastorVerificationRequest;
import com.example.churchmanagement.dto.response.PastorResponse;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.exception.RegistrationVerificationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PastorServiceTest {
@Autowired
private PastorService pastorService;
@Autowired
private ChurchService churchService;
private PastorRequest pastorRequest1;
private DateZ dateOfBirth1;
private DateZ dateOfBirth2;

private PastorRequest pastorRequest2;
private PastorRequest pastorRequest3;
private Address address1;
private Address address2;
private PastorVerificationRequest verifyRequest;
    @BeforeEach
    void setUp() {
        dateOfBirth1 = new DateZ();
        dateOfBirth1.setDate("06");
        dateOfBirth1.setMonth("04");
        dateOfBirth1.setYear("1990");

        address1 = new Address();
        address1.setHouseNumber("103");
        address1.setState("lagos_State");
        address1.setStreetName("ilaje road");
        address1.setLocalGovernment("bariga");


        pastorRequest1 = new PastorRequest();
        pastorRequest1.setAddress(address1);
        pastorRequest1.setDateOfBirth(dateOfBirth1);
        pastorRequest1.setFirstName("goatNational");
        pastorRequest1.setChurchName("StrongTower");
        pastorRequest1.setLastName("goat");
        pastorRequest1.setPhoneNumber("09099332737");
        pastorRequest1.setEmailAddress("pastorAccount01@mailinator.com");
        pastorRequest1.setProfile_picture("C:\\Users\\USER\\Pictures\\a7x\\boneshaker.jpg");
        pastorRequest1.setGender(Gender.MALE);
        pastorRequest1.setPassword("i am a monkey231");




        pastorRequest2 = new PastorRequest();
        pastorRequest2.setFirstName("elijah");
        pastorRequest2.setLastName("Echo");
        pastorRequest2.setPhoneNumber("09099332737");
        pastorRequest2.setEmailAddress("pastorAccount02.mailinator@mailinator.com");

        address2 = new Address();
        address2.setHouseNumber("290");
        address2.setState("lagos_State");
        address2.setStreetName("ilaje road");

        dateOfBirth2 = new DateZ();

        dateOfBirth2.setDate("27");
        dateOfBirth2.setMonth("04");
        dateOfBirth2.setYear("2009");

        pastorRequest2.setDateOfBirth(dateOfBirth2);
        address2.setLocalGovernment("bariga");
        pastorRequest2.setAddress(address2);
        pastorRequest2.setProfile_picture("C:\\Users\\USER\\Pictures\\a7x\\boneshaker.jpg");
        pastorRequest2.setGender(Gender.MALE);
        pastorRequest2.setPassword("boneshaker123");
        pastorRequest2.setChurchName("jehovahnessi");

        pastorRequest3 = new PastorRequest();
        pastorRequest3.setLastName("leadGuitar");
        pastorRequest3.setFirstName("blues");
        pastorRequest3.setEmailAddress("pastorAccount01@mailinator.com");
        pastorRequest3.setPassword("brucewyne123");
        pastorRequest3.setDateOfBirth(dateOfBirth1);





    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @Disabled
    void testThatWeCanCreateANewPastorAccount()  {

        pastorService.RegisterNewPastorAccount( pastorRequest1);
        pastorService.RegisterNewPastorAccount( pastorRequest2);
        assertEquals(2, pastorService.countPastorAccounts());

    }

@Disabled
    @Test
    void testThatDeleteAllPastorsAccount(){
    pastorService.deleteAllPastorAccount();
    assertEquals(0,pastorService.countPastorAccounts());
    }
    @Test
    void testThatPastorCanSetToLeadAChurch(){

        String token = churchService.tokenGenerator("itsezebruce19@gmail.com").getToken();


        assertEquals("completed",
        pastorService.setPastorToLeadAChurch("itsezebruce19@gmail.com","pastorAccount01@mailinator.com",token));

    }
    @Test
    void testThatWeCanFindPastorAccountByEmailAddress(){
        assertEquals("Echo", pastorService.findPastorByEmailAddress("pastorAccount02.mailinator@mailinator.com").getLastName());

    }
    @Test
    void testThaWeCanGenerateToken(){
        assertNotNull(pastorService.generatePastorToken("pastorAccount01@mailinator.com"));

    }
    @Test
    void testThatWeCanVerifyPastorAccount(){
        String token = pastorService.generatePastorToken("pastorAccount01@mailinator.com").getToken();
    assertDoesNotThrow(()->{pastorService.validatePastorAccount("pastorAccount01@mailinator.com","i am a monkey231",token);});

    String token2 = pastorService.generatePastorToken("pastorAccount02.mailinator@mailinator.com").getToken();
    assertDoesNotThrow(()->{pastorService.validatePastorAccount("pastorAccount02.mailinator@mailinator.com","boneshaker123",token2);});
    }
    @Test
    void testThatWeCanDeletePastorAccount(){
        String token = pastorService.generatePastorToken("pastorAccount01@mailinator.com").getToken();
assertDoesNotThrow(()->{ pastorService.deletePastorAccountByEmail("pastorAccount01@mailinator.com",token);
});

//        assertEquals(1, pastorService.countPastorAccounts());
    }

    @Test
    void testThatWeCanUpdatePastorAccount(){
        assertEquals("blues", pastorService.completeUpdateForPastorAccount(pastorRequest3).getLastName());
    }
    @Test
    void testThatWeCanGetAllPastor(){
        List<PastorResponse> listOfPastor = pastorService.getAllPastors(5,7);
        assertTrue(listOfPastor.isEmpty());
    }
    @Test
    void testThatPastorCanChangePassword(){
        String token = pastorService.generatePastorToken("pastorAccount01@mailinator.com").getToken();
        assertEquals("success", pastorService.changePassword("pastorAccount01@mailinator.com","i am a monkey231","meAsAGoat564",token));

    }
    @Test
    void testThatPastorCanLostPassword(){
    String token = pastorService.generatePastorToken("pastorAccount01@mailinator.com").getToken();
    }

}