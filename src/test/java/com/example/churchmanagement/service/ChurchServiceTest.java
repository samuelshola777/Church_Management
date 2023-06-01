package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.ChurchType;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChurchServiceTest {
    @Autowired
    ChurchService churchService;

 private  ChurchRequest churchRequest1;
 private  ChurchRequest churchRequest2;
 private Address address2;
 private Address address1;
    @BeforeEach
    void setUp() {

  address1 = new Address();
    address1.setLocalGovernment("Akoka Environment");
    address1.setStreetName("cent finbas road");
    address1.setState("lagos state");
    address1.setHouseNumber("67");



    address2 = new Address();
    address2.setLocalGovernment("pedro road");
    address2.setStreetName("Ladi lak");
    address2.setState("lagos state");
    address2.setHouseNumber("23");

    churchRequest1 = new ChurchRequest();
    churchRequest1.setChurchType(ChurchType.HEADQUARTER);
    churchRequest1.setChurchBranchName("StrongTower");
    churchRequest1.setAddress(address1);
    churchRequest1.setPhoneNumber("09062666877");
    churchRequest1.setPassword("cowubuubbub123");

    churchRequest2 = new ChurchRequest();
    churchRequest2.setChurchType(ChurchType.BRANCH);
    churchRequest2.setChurchBranchName("Discovery center");
    churchRequest2.setAddress(address2);
    churchRequest2.setPhoneNumber("09099332737");
    churchRequest2.setPassword("goatojjbujbu123");
    churchRequest2.setEmailAddress("samuelshola14@gmail.com");
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testThatWeCanRegisterANewChurchCenter() throws PhoneNumberException, PasswordException, RegistrationException, TokenException {
    churchService.registerANewChurchBranch(churchRequest1);
    churchService.registerANewChurchBranch(churchRequest2);

    }
    @Test
    void testThatWeCanDeleteAllChurchBranchFromTempoRepo(){
        churchService.deleteAllChurchBranch();
    assertEquals(0, churchService.tempoRepoCountChurchBranch());

    }
    @Test
    void testThatWeCanFindChurchBranchByEmailAddress(){
    assertEquals("09099332737", churchService.f);

    }
}