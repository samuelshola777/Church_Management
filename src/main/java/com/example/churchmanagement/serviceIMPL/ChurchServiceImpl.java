package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.ToolZ;
import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.data.model.ValidationState;
import com.example.churchmanagement.dto.request.ChangeChurchAddressRequest;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.dto.response.ChurchResponse;
import com.example.churchmanagement.emailEngine.service.EmailRequest.ForgotPasswordRequest;
import com.example.churchmanagement.emailEngine.service.EmailRequest.GenerateTokenRequest;
import com.example.churchmanagement.emailEngine.service.EmailService;
import com.example.churchmanagement.exception.*;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.data.repository.ChurchRepository;
import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import com.example.churchmanagement.tokenZ.service.ChurchTokenService;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ChurchServiceImpl implements ChurchService {
    @NonNull
    private final ChurchRepository churchRepository;
    @NonNull
    private final ToolZ tool;
    @NonNull
    private final ChurchTokenService churchTokenService;
    @NonNull
    private final EmailService emailService;

    @Override
    public ChurchResponse registerANewChurchBranch(ChurchRequest churchRequest2) {
   // registrationIfPhoneNumberExist(churchRequest2.getPhoneNumber());
        ChurchBranch churchBranch;
        if (registerCheckIfEmailExists(churchRequest2.getEmailAddress())){
         churchBranch = completeUpDate(churchRequest2.getEmailAddress());
         churchBranch.setValidationState(ValidationState.PENDING);
       return mapToResponse(  churchRepository.save(churchBranch));
        }
      churchBranch   = mapToRequest(churchRequest2);
        tool.phoneNumberValidator(churchBranch.getPhoneNumber());
      tool.passwordValidator(churchBranch.getPassword());
      ChurchTokenZ token = churchTokenService.createTokenForChurchBranch(churchBranch.getChurchBranchName());
      churchBranch.setCreatedAt(LocalDateTime.now());
      churchBranch.setValidationState(ValidationState.PENDING);
      churchBranch.setToken(token.getToken());
      token.setChurchBranch(churchBranch);
        ChurchTokenZ savedToken = churchTokenService.saveToken(token);
        churchBranch.addToken(savedToken);
        ChurchBranch savedChurchBranch = churchRepository.save(churchBranch);
        return mapToResponse(savedChurchBranch);
    }

    private boolean registerCheckIfEmailExists(String email) {
        ChurchBranch churchBranch = churchRepository.findByEmailAddress(email);
  if (churchBranch != null && churchBranch.getValidationState() == ValidationState.INVALID){
      return true;}
  if (churchBranch != null)throw new RegistrationException(" Church branch with the email address  "+email+ "  already exists");
return false;
    }

    private ChurchBranch mapToRequest(ChurchRequest churchRequest2) {
        return ChurchBranch.builder()
                .churchBranchName(churchRequest2.getChurchBranchName())
                .churchType(churchRequest2.getChurchType())
                .password(churchRequest2.getPassword())
                .id(churchRequest2.getId())
                .phoneNumber(churchRequest2.getPhoneNumber())
                .address(churchRequest2.getAddress())
                .validationState(churchRequest2.getValidationState())
                .emailAddress(churchRequest2.getEmailAddress()).build();
    }


    public ChurchResponse findChurchByName(String churchName) {
        ChurchBranch foundChurch = churchRepository.findByChurchBranchName(churchName);
        if (foundChurch == null  )throw new RegistrationException("account not found");
        if (foundChurch.getValidationState() == ValidationState.INVALID) throw new RegistrationException("account not found");
        return mapToResponse(foundChurch);
    }

    @Override
    public void deleteAllChurchBranch() {
        churchRepository.deleteAll();
    }

    @Override
    public ChurchBranch findChurchBranchByEmailAddress(String emailAddress) {
        log.info("Called method 2");
        ChurchBranch foundChurch = churchRepository.findByEmailAddress(emailAddress);
        log.info("Called method 3");
        if (foundChurch == null ||
        foundChurch.getValidationState() == ValidationState
        .INVALID) throw new FindingExection("church branch does not exist");
        log.info("Called method 4");
        return foundChurch;
    }

    @Override
    public ChurchResponse findByEmailResponse(String email) {
      return  mapToResponse( findChurchBranchByEmailAddress(email));
    }

    public ChurchResponse mapToResponse(ChurchBranch foundChurchBranch ){
        ChurchResponse churchResponse = new ChurchResponse();
        churchResponse.setChurchBranchName(foundChurchBranch.getChurchBranchName());
        churchResponse.setChurchType(foundChurchBranch.getChurchType());
       churchResponse.setToken(foundChurchBranch.getToken());
        churchResponse.setEmailAddress(foundChurchBranch.getEmailAddress());
        churchResponse.setAddress(foundChurchBranch.getAddress());
        churchResponse.setValidationState(foundChurchBranch.getValidationState());
        return churchResponse;
    }
    @Override
    public ChurchResponse changeChurchBranchName(String mail, String newBranchName){
        ChurchBranch foundChurchBranch = findChurchBranchByEmailAddress(mail);
        checkIfInvalid(foundChurchBranch);
        foundChurchBranch.setChurchBranchName(newBranchName);
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
     public ChurchBranch completeUpDate(String email){
       ChurchBranch churchBranch = churchRepository.findByEmailAddress(email);
        return ChurchBranch.builder()
                .id(churchBranch.getId())
                .validationState(churchBranch.getValidationState())
                .churchType(churchBranch.getChurchType())
                .emailAddress(churchBranch.getEmailAddress())
                .address(churchBranch.getAddress())
                .password(churchBranch.getPassword())
                .churchBranchName(churchBranch.getChurchBranchName())
                .phoneNumber(churchBranch.getPhoneNumber())
                .createdAt(churchBranch.getCreatedAt()).build();

     }

    @Override
    public ChurchResponse changeChurchPassword(String emailAddress, String newPassword) {
        ChurchBranch foundChurch = findChurchBranchByEmailAddress(emailAddress);
        tool.passwordValidator(newPassword);
        foundChurch.setPassword(newPassword);
        churchRepository.save(foundChurch);
        return mapToResponse(foundChurch);
    }


    @Override
    public long countAllChurchBranch() {
        return churchRepository.count();
    }

    @Override
    public ChurchTokenZ tokenGenerator(String email){
        ChurchBranch foundChurch = findChurchBranchByEmailAddress(email);
        ChurchTokenZ createdToken =   churchTokenService.createTokenForChurchBranch(foundChurch.getChurchBranchName());
       createdToken.setChurchBranch(foundChurch);
        foundChurch.setToken(createdToken.getToken());
        GenerateTokenRequest generateTokenRequest = new GenerateTokenRequest(createdToken.getToken(),foundChurch.getEmailAddress());
    //  emailService.generateTokenRequest(generateTokenRequest);
     churchTokenService.saveToken(createdToken);
        churchRepository.save(foundChurch);
        return createdToken;
    }

    @Override
    public ChurchResponse verifyChurchAccount(String mail, String password, String token)  {
   ChurchBranch   foundChurchAccount   = findChurchBranchByEmailAddress(mail);
   if (! foundChurchAccount.getPassword().equalsIgnoreCase(password)) throw new PasswordException("incorrect password");
    if (! foundChurchAccount.getToken().equalsIgnoreCase(token)) throw new TokenException("incorrect token");
     foundChurchAccount.setValidationState(ValidationState.VALIDATED);
     churchRepository.save(foundChurchAccount);
        return mapToResponse(foundChurchAccount);
    }

    @Override
    public void deleteChurchBranchByEmailAddress(String mail,String token)  {
        try {
        ChurchBranch churchBranch = findChurchBranchByEmailAddress(mail);
        if (! token.equalsIgnoreCase(churchBranch.getToken())) throw new TokenException("Token does not match");
            churchBranch.setValidationState(ValidationState.INVALID);
            churchRepository.save(churchBranch);
        }catch (TokenException k){
        throw new TokenException("Token does not match");
        }
        }

    private void registrationIfPhoneNumberExist(String phoneNumber){
        ChurchBranch churchBranch = churchRepository.findByPhoneNumber(phoneNumber);
        if (churchBranch != null && churchBranch.getValidationState() != ValidationState.INVALID)
            throw new RegistrationException("account already exists");

}

    public void checkIfInvalid(ChurchBranch churchBranch){
        if (churchBranch.getValidationState() == ValidationState.INVALID)
            throw new InvalidAccountException("INVALID ACCOUNT");
    }

    @Override
    public void deleteChurchBranchById(long id) {
        churchRepository.deleteById(id);
    }

    @Override
    public Page<ChurchBranch> getAllChurchBranch(int offSet, int pageSize) {
        return churchRepository.findAll(PageRequest.of(offSet, pageSize));
    }

    @Override
    public ChurchResponse forgotPassword(String mail, String token) {
        ChurchBranch churchBranch = findChurchBranchByEmailAddress(mail);
        if (! churchBranch.getToken().equals(token)) throw new TokenException("Token does not match");
        String newPassword = tool.passwordGenerator(churchBranch);
        churchBranch.setPassword(newPassword);
        churchRepository.save(churchBranch);
        ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest(newPassword,mail);
        forgotPasswordRequest.setNewPassword(newPassword);
         //  emailService.forgotPasswordMailSender(forgotPasswordRequest);
        return mapToResponse(churchBranch);
    }

    @Override
    public void deleteAllTokenByChurchEmail(String mail) {
        churchRepository.deleteAllChurchTokenZByEmailAddress(mail);
    }

    private void emailExistingConfirmation(String email){


    }

}
