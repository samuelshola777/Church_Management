package com.example.churchmanagement.emailEngine.service.EmailRequest;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ForgotPasswordRequest {
    private String forgetPasswordHeader = "NEW PASSWORD ASSISTANCE";
    @NonNull
    private String newPassword ;
    @NonNull
    private String receiverEmail;
    private String forgotPasswordMessage = " good day we at church manager are sorry about the lost password" +
            "your new password is  ==>  ";

}
