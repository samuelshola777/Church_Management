package com.example.churchmanagement.emailEngine.service;

import com.example.churchmanagement.emailEngine.service.EmailRequest.ChurchRegistrationEmailRequest;
import com.example.churchmanagement.emailEngine.service.EmailRequest.ForgotPasswordRequest;

public interface EmailService {
    void sendEmail();
    void churchRegistrationMailSender(String receiverEmail, String token);

    void forgotPasswordMailSender(ForgotPasswordRequest forgotPasswordRequest);
}
