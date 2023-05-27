package com.example.churchmanagement.app;

import com.example.churchmanagement.sendingBlue.MailConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {

    @Value("${sending_blue_api_key }")
    private String apiKey;

    @Value("${sendinblue_mail}")
    private String sendingBlueUrl;

    @Bean
    public JavaMailSender javaMailSender() {
     return new JavaMailSenderImpl();
    }
    @Bean
    public MailConfig mailConfig(){
        return new MailConfig(apiKey,sendingBlueUrl);
    }



}
