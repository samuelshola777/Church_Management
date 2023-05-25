package com.example.churchmanagement;

import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.exception.PasswordException;
import com.example.churchmanagement.exception.PhoneNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ToolZ {

    public void phoneNumberValidator(String phoneNumber) throws PhoneNumberException {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.length() != 11)
                throw new PhoneNumberException("invalid phone number: " + phoneNumber);
        }
    }
    public void passwordValidator(String password) throws PasswordException {
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) digitCount++;
        }
            if (digitCount < 3) throw new PasswordException("password should contain at least 3 digits");
            if (password.length() < 12) throw new PasswordException("password most contain at least 12 characters");


    }

    }

