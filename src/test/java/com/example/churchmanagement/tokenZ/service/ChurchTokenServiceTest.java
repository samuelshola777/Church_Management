package com.example.churchmanagement.tokenZ.service;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.data.model.ChurchType;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class ChurchTokenServiceTest {
@Autowired
private ChurchTokenService churchTokenService;
private  ChurchBranch churchBranch1;
private  ChurchBranch churchBranch2;
private Address address1;
private Address address2;

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

        churchBranch1 = new ChurchBranch();
        churchBranch1.setChurchType(ChurchType.HEADQUARTER);
        churchBranch1.setChurchBranchName("Strong Tower");
        churchBranch1.setAddress(address1);
        churchBranch1.setPhoneNumber("09062666877");
        churchBranch1.setPassword("cow123");

        churchBranch2 = new ChurchBranch();
        churchBranch2.setChurchType(ChurchType.BRANCH);
        churchBranch2.setChurchBranchName("Discovery center");
        churchBranch2.setAddress(address2);
        churchBranch2.setPhoneNumber("09099332737");
        churchBranch2.setPassword("goat123");
    }

    @AfterEach
    void tearDown() {

    }
    @Test
    void testThatWeCanCreateToken() throws TokenException {

        churchTokenService.createTokenForChurchBranch(churchBranch1);
        churchTokenService.createTokenForChurchBranch(churchBranch2);
       assertEquals(2, churchTokenService.countChurchToken());


    }
    @Test
    void testThatWeCanDeleteAllToken(){
        churchTokenService.deleteAllToken();
        assertEquals(0, churchTokenService.countChurchToken());
    }
}