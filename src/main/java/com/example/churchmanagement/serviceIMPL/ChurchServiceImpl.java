package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.ToolZ;


import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.data.temRepository.ChurchTempoRepo;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.dto.response.ChurchResponse;
import com.example.churchmanagement.emailEngine.service.EmailService;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import com.example.churchmanagement.exception.RegistrationException;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.data.repository.ChurchRepository;
import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import com.example.churchmanagement.tokenZ.service.ChurchTokenService;
import com.example.churchmanagement.tokenZ.tokenException.TokenException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ChurchServiceImpl implements ChurchService {

private final ChurchRepository churchRepository;

private final ChurchTempoRepo churchTempoRepo;

private final ToolZ tool;

private final ChurchTokenService churchTokenService;

private final EmailService emailService;


    @Override
    public void registerANewChurchBranch(ChurchRequest churchRequest2) throws PhoneNumberException, PasswordException, RegistrationException, TokenException {
        ChurchBranch churchBranch = mapToRequest(churchRequest2);
    //    registrationIfPhoneNumberExist(churchBranch.getPhoneNumber());
        tool.phoneNumberValidator(churchBranch.getPhoneNumber());
        tool.passwordValidator(churchBranch.getPassword());
       ChurchTokenZ token = churchTokenService.createTokenForChurchBranch(churchBranch.getChurchBranchName());
       churchBranch.setCreatedAt(LocalDateTime.now());
        churchBranch.setToken(token.getToken());
        churchBranch.initializisation();
        churchBranch.addToken(token);
    //  emailService.sendEmail();
 //  churchTempoRepo.save(churchBranch);

    }
    private ChurchBranch mapToRequest(ChurchRequest churchRequest2){
    return    ChurchBranch.builder()
                .churchBranchName(churchRequest2.getChurchBranchName())
                .churchType(churchRequest2.getChurchType())
                .password(churchRequest2.getPassword())
                .phoneNumber(churchRequest2.getPhoneNumber())
                 .address(churchRequest2.getAddress())
                .emailAddress(churchRequest2.getEmailAddress()).build();
    }


 public ChurchBranch findChurchByName(String churchName) throws RegistrationException {
        ChurchBranch foundChurch = churchTempoRepo.findByChurchBranchName(churchName);
        if (foundChurch == null) throw new RegistrationException("account not found");
        return foundChurch;
 }

    @Override
    public void deleteAllChurchBranch() {
        churchTempoRepo.deleteAll();
    }

    @Override
    public long tempoRepoCountChurchBranch() {
        return churchTempoRepo.count();
    }

    private String registrationIfPhoneNumberExist(String phoneNumber) throws RegistrationException {
        ChurchBranch churchBranch = churchTempoRepo.findByPhoneNumber(phoneNumber);
        try {
        if (churchBranch != null) {
            throw new RegistrationException("account already exists");
            }
        }catch (RegistrationException kue) {
            throw new RegistrationException("account already exists");
        }
        return "successful";
}

}
