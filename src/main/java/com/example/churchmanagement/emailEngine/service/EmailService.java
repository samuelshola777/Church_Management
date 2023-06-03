package com.example.churchmanagement.emailEngine.service;

import com.example.churchmanagement.emailEngine.service.EmailRequest.ChurchRegistrationEmailRequest;

public interface EmailService {
    void sendEmail();
    void churchRegistrationMailSender(String receiverEmail, String token);
}
