package com.example.churchmanagement.emailEngine.service;

import com.example.churchmanagement.emailEngine.service.EmailRequest.ChurchRegistrationEmailRequest;
import com.example.churchmanagement.emailEngine.service.EmailRequest.ForgotPasswordRequest;
import com.example.churchmanagement.emailEngine.service.EmailRequest.GenerateTokenRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService{


    private final JavaMailSender mailSender;

//    If your email is intended for multiple recipients’, then there is
//    a simple way to do bulk email sending with Spring Boot. This can be done by
//    following the same steps outlined above, adding a String[] in message.setTo
//    method and provide the list of recipient email addresses separated by a comma.
//
//            message.setTo(new String[] {"recipient1@example.com","samuelshola14@gmail.com"})

//
//    String recipient = "john.doe@example.com";
//    String subject = "Hello, ${firstName}!";
//    String template = "Hello, ${firstName}!\n\n"
//            + "This is a message just for you, ${firstName} ${lastName}. "
//            + "We hope you're having a great day!\n\n"
//            + "Best regards,\n"
//            + "The Spring Boot Team";
//
//    Map<String, Object> variables = new HashMap<>();
//variables.put("firstName", "John");
//variables.put("lastName", "Doe");
//
//    sendEmail(recipient, subject, template, variables);



    public  void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("samuelshola14@Gmail.com");
        message.setTo("samuelshola14@gmail.com");
        message.setSubject("trying the mail send");
        message.setText("sending mail");

        mailSender.send(message);
    }

    @Override
    public void churchRegistrationMailSender( String token, String receiverEmail) {
        ChurchRegistrationEmailRequest request =  ChurchRegistrationEmailRequest.
        builder().emailAddress(receiverEmail).verificationToken(token).build();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("samuelshola14@gmail.com");
        message.setTo("samuelshola14@gmail.com");
        message.setSubject(request.getRegistrasionTopic());
        message.setText(request.getMessage());
        mailSender.send(message);
    }

    @Override
    public void forgotPasswordMailSender(ForgotPasswordRequest forgotPasswordRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("samuelshola14@gmail.com");
        message.setTo(forgotPasswordRequest.getReceiverEmail());
        message.setSubject(forgotPasswordRequest.getForgetPasswordHeader());
        message.setText(forgotPasswordRequest.getForgotPasswordMessage()+"  "+forgotPasswordRequest.getNewPassword());
        mailSender.send(message);
    }

    @Override
    public void generateTokenRequest(GenerateTokenRequest tokenRequest) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("samuelshola14@gmail.com");
        message.setTo(tokenRequest.getReceiverEmail());
        message.setSubject(tokenRequest.getTokenHeader());
        message.setText(tokenRequest.getTokenMessage()+"  "+tokenRequest.getToken());
        mailSender.send(message);
    }


}
