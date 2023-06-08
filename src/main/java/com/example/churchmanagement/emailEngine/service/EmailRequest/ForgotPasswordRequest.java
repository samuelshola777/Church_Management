package com.example.churchmanagement.emailEngine.service.EmailRequest;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ForgotPasswordRequest {
    private String forgetPasswordHeader = " \uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE0E NEW PASSWORD ASSISTANCE \uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE0E\uD83D\uDE0E";
    @NonNull
    private String newPassword ;
    @NonNull
    private String receiverEmail;
    private String forgotPasswordMessage = " good day we at church manager are sorry about the lost password" +
            "your new password is  ==>  ";

}
