package com.example.churchmanagement.app;

import com.example.churchmanagement.sendingBlue.MailConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {

    @Value("${sending_blue_api_key}")
    private String apiKey;

    @Value("${sendinblue_mail}")
    private String sendingBlueUrl;

    @Value("${spring.mail.password}")
    private String emailPassword;
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setProtocol("smtp");
        sender.setUsername("samuelshola14@gmail.com");
        sender.setPassword(emailPassword);

        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", true);
        mailProperties.put("mail.smtp.starttls.enable", true);
        mailProperties.put("mail.smtp.timeout", 5000);
        mailProperties.put("mail.smtp.connectiontimeout", 5000);
        mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        sender.setJavaMailProperties(mailProperties);

     return sender;
    }

    @Bean
    public MailConfig mailConfig(){
        return new MailConfig(apiKey,sendingBlueUrl);
    }



}
