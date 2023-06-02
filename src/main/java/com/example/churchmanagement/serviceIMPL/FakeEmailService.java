package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.emailEngine.service.EmailService;

public class FakeEmailService implements EmailService {
    @Override
    public void sendEmail() {
        System.out.println("Sent");
    }
}
