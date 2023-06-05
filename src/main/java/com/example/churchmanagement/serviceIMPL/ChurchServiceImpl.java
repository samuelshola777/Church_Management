package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.ToolZ;
import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.data.model.ValidationState;
import com.example.churchmanagement.dto.request.ChangeChurchAddressRequest;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.dto.response.ChurchResponse;
import com.example.churchmanagement.emailEngine.service.EmailService;
import com.example.churchmanagement.exception.FindingExection;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.data.repository.ChurchRepository;
import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import com.example.churchmanagement.tokenZ.service.ChurchTokenService;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ChurchServiceImpl implements ChurchService {

private final ChurchRepository churchRepository;

private final ToolZ tool;

private final ChurchTokenService churchTokenService;

private final EmailService emailService ;



    @Override
    public void registerANewChurchBranch(ChurchRequest churchRequest2) throws PhoneNumberException, PasswordException, RegistrationException, TokenException {
        ChurchBranch churchBranch = mapToRequest(churchRequest2);
        registrationFindChurchBranchByEmail(churchBranch.getEmailAddress());
         registrationIfPhoneNumberExist(churchBranch.getPhoneNumber());
        tool.phoneNumberValidator(churchBranch.getPhoneNumber());
        tool.passwordValidator(churchBranch.getPassword());
       ChurchTokenZ token = churchTokenService.createTokenForChurchBranch(churchBranch.getChurchBranchName());
       churchBranch.setCreatedAt(LocalDateTime.now());
        churchBranch.setToken(token.getToken());
        churchBranch.initializisation();
        churchBranch.addToken(token);
        System.out.println("this is registration token  ()---->   " + token.getToken());
      // emailService.churchRegistrationMailSender(churchBranch.getToken(), churchBranch.getEmailAddress());
        churchRepository.save(churchBranch);

    }

    private ChurchBranch mapToRequest(ChurchRequest churchRequest2){
    return    ChurchBranch.builder()
                .churchBranchName(churchRequest2.getChurchBranchName())
                .churchType(churchRequest2.getChurchType())
                .password(churchRequest2.getPassword())
                .phoneNumber(churchRequest2.getPhoneNumber())
                 .address(churchRequest2.getAddress())
            .validationState(churchRequest2.getValidationState())
                .emailAddress(churchRequest2.getEmailAddress()).build();
    }


 public ChurchBranch findChurchByName(String churchName) throws RegistrationException {
        ChurchBranch foundChurch = churchRepository.findByChurchBranchName(churchName);
        if (foundChurch != null) throw new RegistrationException("account not found");
        return foundChurch;
 }

    @Override
    public void deleteAllChurchBranch() {
        churchRepository.deleteAll();
    }

    @Override
    public ChurchBranch findChurchBranchByEmailAddress(String emailAddress) throws FindingExection {
      ChurchBranch foundChurchBranch = churchRepository.findChurchBranchByEmailAddress(emailAddress);
   if (foundChurchBranch == null) throw new FindingExection("church branch does not exist");
   return foundChurchBranch;
    }


    public void registrationFindChurchBranchByEmail(String email) {
        try {
            ChurchBranch foundChurch = churchRepository.findChurchBranchByEmailAddress(email);
            if (foundChurch != null)
                throw new RegistrationException("church with email address " + email + " already exists");
        }catch (RegistrationException k){
            throw new RuntimeException("church with email address " + email + " already exists");
        }
    }




    public ChurchResponse mapToResponse(ChurchBranch foundChurchBranch ){
        ChurchResponse churchResponse = new ChurchResponse();
        churchResponse.setChurchBranchName(foundChurchBranch.getChurchBranchName());
        churchResponse.setChurchType(foundChurchBranch.getChurchType());
        churchResponse.setEmailAddress(foundChurchBranch.getEmailAddress());
        churchResponse.setAddress(foundChurchBranch.getAddress());
        churchResponse.setValidationState(foundChurchBranch.getValidationState());
        return churchResponse;
    }
    @Override
    public ChurchResponse changeChurchBranchName(String mail, String strongTowerMinistry) throws FindingExection {
      // TODO there most be an email verification
      //emailService.sendEmail();
        // TODO after the verification is complete then the system proceed
        ChurchBranch foundChurchBranch = findChurchBranchByEmailAddress(mail);
        foundChurchBranch.setChurchBranchName(strongTowerMinistry);
        churchRepository.save(foundChurchBranch);
        // TODO a notification mail will be sent that the churchBranchName has been changed
     return mapToResponse(foundChurchBranch);
    }

    @Override
    public ChurchResponse changeChurchAddress(ChangeChurchAddressRequest changeChurchAddress1)  {
        ChurchBranch foundChurchBranch;
        try {
            foundChurchBranch = findChurchBranchByEmailAddress(changeChurchAddress1.getChurchBranchEmailAddress());
            Address address = new Address();
            address.setHouseNumber(changeChurchAddress1.getHouseNumber());
            address.setState(changeChurchAddress1.getState());
            address.setStreetName(changeChurchAddress1.getStreetName());
            address.setLocalGovernment(changeChurchAddress1.getLocalGovernment());
            foundChurchBranch.setAddress(address);
        }catch (FindingExection k){
            throw new IllegalStateException("account can't be found");
        }
    return mapToResponse(foundChurchBranch);
    }

    @Override
    public ChurchResponse changeChurchPassword(String glassPANEL) {
        return null;
    }


    @Override
    public String deleteByEmail(String mail, String token) throws FindingExection, TokenException {
        ChurchBranch foundChurch = findChurchBranchByEmailAddress(mail);
    //TODO a verification code will be sent to confirm deletion of church branch
    // TODO if the verification code is confirmed the deletion will take place
    if (token.equals(foundChurch.getToken())) {

    }
        return null;
    }

    @Override
    public long countAllChurchBranch() {
        return churchRepository.count();
    }

    @Override
    public ChurchTokenZ tokenGenerator(String email, String tokenName) throws FindingExection, TokenException {
        ChurchBranch foundChurch = findChurchBranchByEmailAddress(email);
        ChurchTokenZ foundToken =   churchTokenService.createTokenForChurchBranch(foundChurch.getChurchBranchName());
        foundChurch.setToken(foundToken.getToken());
        churchRepository.save(foundChurch);
        return foundToken;
    }

    @Override
    public ChurchResponse verifyChurchAccount(String mail, String password) throws FindingExection, PasswordException {
   ChurchBranch   foundChurchAccount   = findChurchBranchByEmailAddress(mail);
   if (! foundChurchAccount.getPassword().equalsIgnoreCase(password)) throw new PasswordException("incorrect password");
     foundChurchAccount.setValidationState(ValidationState.VALIDATED);
     churchRepository.save(foundChurchAccount);
        return mapToResponse(foundChurchAccount);
    }

    private void registrationIfPhoneNumberExist(String phoneNumber) throws RegistrationException {
        ChurchBranch churchBranch = churchRepository.findByPhoneNumber(phoneNumber);
        try {
        if (churchBranch != null) {
            throw new RegistrationException("account already exists");
            }
        }catch (RegistrationException kue) {
            throw new RegistrationException("account already exists");
        }
}



}
