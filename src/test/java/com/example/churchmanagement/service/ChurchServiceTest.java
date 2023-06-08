package com.example.churchmanagement.service;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.data.model.ChurchType;
import com.example.churchmanagement.data.model.ValidationState;
import com.example.churchmanagement.dto.request.ChangeChurchAddressRequest;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.exception.*;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChurchServiceTest {
    @Autowired
    ChurchService churchService;

 private  ChurchRequest churchRequest1;
 private  ChurchRequest churchRequest2;
 private  ChurchRequest churchRequest3;
 private Address address2;
 private Address address3;
 private Address address1;
 private ChangeChurchAddressRequest changeChurchAddress1;
    @BeforeEach
    void setUp() {
        changeChurchAddress1 = new ChangeChurchAddressRequest();
        changeChurchAddress1.setChurchBranchEmailAddress("samuelshola14@gmail.com");
        changeChurchAddress1.setState("lagos");
        changeChurchAddress1.setLocalGovernment("akoka");
        changeChurchAddress1.setHouseNumber("57");
        changeChurchAddress1.setStreetName("cent finbace road");

    address1 = new Address();
    address1.setLocalGovernment("Akoka Environment");
    address1.setStreetName("cent finbas road");
    address1.setState("lagos state");
    address1.setHouseNumber("67");



    address3 = new Address();
    address3.setLocalGovernment("Bariga_ilaje");
    address3.setStreetName("oremeji_junction");
    address3.setState("lagos state");
    address3.setHouseNumber("87");

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
    churchRequest1.setPassword("cloudinary127");
    churchRequest1.setEmailAddress("itsezebruce19@gmail.com");

    churchRequest2 = new ChurchRequest();
    churchRequest2.setChurchType(ChurchType.BRANCH);
    churchRequest2.setChurchBranchName("Discovery center");
    churchRequest2.setAddress(address2);
    churchRequest2.setPhoneNumber("09099332737");
    churchRequest2.setPassword("goatojjbujbu123");
    churchRequest2.setEmailAddress("samuelshola14@gmail.com");

    churchRequest3 = new ChurchRequest();
    churchRequest3.setChurchType(ChurchType.HEADQUARTER);
    churchRequest3.setChurchBranchName("PICC");
    churchRequest3.setAddress(address3);
    churchRequest3.setPhoneNumber("08095279090");
    churchRequest3.setPassword("GodOfTHUNDER123");
    churchRequest3.setEmailAddress("jojololamartins686@gmail.com");


    }

    @AfterEach
    void tearDown() {
    }
    @Disabled
    @Test
    void testThatWeCanRegisterANewChurchCenter() throws PhoneNumberException, PasswordException, RegistrationException, TokenException {
   churchService.registerANewChurchBranch(churchRequest1);
   churchService.registerANewChurchBranch(churchRequest2);
   churchService.registerANewChurchBranch(churchRequest3);
    assertEquals(3,churchService.countAllChurchBranch());

    }
    @Test
    void testThatWeCanVerifyAccount() throws PasswordException, FindingExection {
    String token = churchService.tokenGenerator("itsezebruce19@gmail.com").getToken();
        assertEquals(ValidationState.VALIDATED, churchService.verifyChurchAccount("itsezebruce19@gmail.com","cloudinary127",token).getValidationState());
    }
    @Disabled
    @Test
    void testThatWeCanDeleteAllChurchBranchFromTempoRepo(){
        churchService.deleteAllChurchBranch();
    assertEquals(0, churchService.countAllChurchBranch());

    }

    @Disabled
    @Test
    void testThatWeCanFindChurchBranchByEmailAddress() throws FindingExection {
    assertEquals(30, churchService.findChurchBranchByEmailAddress("samuelshola14@gmail.com").getId());

    }
    @Test
    void testThatWeCanDeleteById(){
        churchService.deleteChurchBranchById(31);
        assertEquals(3, churchService.countAllChurchBranch());
    }
    @Disabled
    @Test
    void testThatWeCanChangeChurchBranchName() throws FindingExection {
    assertEquals("Strong tower ministry", churchService.changeChurchBranchName("samuelshola14@gmail.com","Strong tower ministry").getChurchBranchName());
    }
    @Disabled
    @Test
  void testThatWeCanChangeChurchAddress() throws FindingExection {
      assertEquals("57", churchService.changeChurchAddress(changeChurchAddress1).getAddress().getHouseNumber());

    }
    @Disabled
    @Test
    void testThatWeCanChangePassword(){
        assertEquals("",churchService.changeChurchPassword("glassPANEL"));
    }

    @Test
    void testThatWeCanDeleteByEmail()  {
      String token = churchService.tokenGenerator("samuelshola14@gmail.com").getToken();
        assertDoesNotThrow(()->{churchService.deleteChurchBranchByEmailAddress("samuelshola14@gmail.com",token);});
    }
    @Test
    void testIfAccountHaveBeenDeactivated(){
        ChurchBranch churchBranch = churchService.findChurchBranchByEmailAddress("samuelshola14@gmail.com");
  assertThrows(InvalidAccountException.class ,()->  churchService.checkIfInvalid(churchBranch));
    }


}