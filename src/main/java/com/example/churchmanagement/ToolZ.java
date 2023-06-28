package com.example.churchmanagement;

import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.data.model.ChurchType;
import com.example.churchmanagement.data.model.DateZ;
import com.example.churchmanagement.data.model.Pastor;
import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.Period;

@Service
public class ToolZ {

    public void phoneNumberValidator(String phoneNumber) throws PhoneNumberException {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.length() != 11)
                throw new PhoneNumberException("invalid phone number: " + phoneNumber);
        }
    }
    public  int calculateAge(DateZ dateZ) {
        int year = Integer.parseInt(dateZ.getYear());
        int month = Integer.parseInt(dateZ.getMonth());
        int day = Integer.parseInt(dateZ.getDate());
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime birthDate = LocalDateTime.of(year, month, day, 0, 0);
        return Period.between(birthDate.toLocalDate(), currentDate.toLocalDate()).getYears();
    }
    public void passwordValidator(String password) throws PasswordException {
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) digitCount++;
        }
            if (digitCount < 3) throw new PasswordException("password should contain at least 3 digits");
            if (password.length() < 12) throw new PasswordException("password most contain at least 12 characters");


    }

    public  String passwordGenerator(ChurchBranch churchBranch){
        String [] weiredWord = {"ULSOW@","TOYRE&","WQUEST#","HNGEW%","OREAN$"};
        SecureRandom secureRandom = new SecureRandom();
        int random = secureRandom.nextInt(weiredWord.length);
        String addAlphabetic = weiredWord[random];
        StringBuilder builder = new StringBuilder(churchBranch.getPassword());
        String newPassword = builder.substring(4,churchBranch.getPassword().length()-1 );
        return addAlphabetic + newPassword;
    }


    public  String passwordGeneratorForPastor(Pastor pastor){
        String [] weiredWord = {"ULSOW@","TOYRE&","WQUEST#","HNGEW%","OREAN$","goat%%%"};
        SecureRandom secureRandom = new SecureRandom();
        int random = secureRandom.nextInt(weiredWord.length);
        String addAlphabetic = weiredWord[random];
        StringBuilder builder = new StringBuilder(pastor.getPassword());
        String newPassword = builder.substring(4,pastor.getPassword().length()-1 );
        return addAlphabetic + newPassword;
    }

    }

