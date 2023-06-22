package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.DateZ;
import com.example.churchmanagement.data.model.Gender;
import com.example.churchmanagement.dto.request.PastorRequest;
import com.example.churchmanagement.dto.request.PastorVerificationRequest;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.exception.RegistrationVerificationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PastorServiceTest {
@Autowired
private PastorService pastorService;

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


        pastorRequest1 = new PastorRequest();
        pastorRequest1.setDateOfBirth(dateOfBirth1);
        pastorRequest1.setFirstName("elijah");
        pastorRequest1.setChurchName("StrongTower");
        pastorRequest1.setLastName("Echo");
        pastorRequest1.setPhoneNumber("09099332737");
        pastorRequest1.setEmailAddress("ebukachukwunenye@gmal.com");
        pastorRequest1.setAddress(address1);
        pastorRequest1.setProfile_picture("C:\\Users\\USER\\Pictures\\a7x\\boneshaker.jpg");
        pastorRequest1.setGender(Gender.MALE);
        pastorRequest1.setPassword("boneshaker123");



        address1 = new Address();
        address1.setHouseNumber("103");
        address1.setState("lagos_State");
        address1.setStreetName("ilaje road");
        address1.setLocalGovernment("bariga");

        pastorRequest2 = new PastorRequest();
        pastorRequest2.setFirstName("elijah");
        pastorRequest2.setLastName("Echo");
        pastorRequest2.setPhoneNumber("09099332737");
        pastorRequest2.setEmailAddress("ebukachukwunenye@gmal.com");

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



        verifyRequest = new PastorVerificationRequest();
       verifyRequest.setPassword("boneshaker123");
        verifyRequest.setEmailAddress("boneshaker@mailinator.com");
        verifyRequest.setToken("7450631sa");
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testThatWeCanCreateANewPastorAccount()  {

        pastorService.RegisterNewPastorAccount( pastorRequest1);
        pastorService.RegisterNewPastorAccount( pastorRequest2);
        assertEquals(2, pastorService.countPastorAccounts());

    }
    @Test
    void testThatPastorCanVerifyAccountAfterTryingToRegister() {
        pastorService.verifyPastorAccount(verifyRequest);
    }

    @Test
    void testThatDeleteAllPastorsAccount(){

    }

}