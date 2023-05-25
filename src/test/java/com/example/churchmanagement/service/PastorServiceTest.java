package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Address;
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
private Address address1;
private PastorVerificationRequest verifyRequest;
    @BeforeEach
    void setUp() {
        pastorRequest1 = new PastorRequest();
        pastorRequest1.setFirstName("samuel");
        pastorRequest1.setLastName("shola");
        pastorRequest1.setPhoneNumber("09099332737");
        pastorRequest1.setEmailAddress("samuelshola14@gmail.com");

        address1 = new Address();
        address1.setHouseNumber("103");
        address1.setState("lagos_State");
        address1.setStreetName("ilaje road");
        address1.setLocalGovernment("bariga");

        pastorRequest1.setAddress(address1);
        pastorRequest1.setProfile_picture("C:\\Users\\USER\\Pictures\\a7x\\boneshaker.jpg");
        pastorRequest1.setGender(Gender.MALE);
        pastorRequest1.setPassword("boneshaker123");

        verifyRequest = new PastorVerificationRequest();
       verifyRequest.setPassword("boneshaker123");
        verifyRequest.setEmailAddress("samuelshola14@gmail.com");
        verifyRequest.setToken("7450631sa");
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testThatWeCanCreateANewPastorAccount() throws PhoneNumberException, PasswordException, RegistrationException {

        pastorService.RegisterNewPastorAccount( pastorRequest1);
        pastorService.countChurchMenber();

    }
    @Test
    void testThatPastorCanVerifyAccountAfterTryingToRegister() throws RegistrationVerificationException {
        pastorService.verifyPastorAccount(verifyRequest);
    }
}