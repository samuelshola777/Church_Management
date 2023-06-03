package com.example.churchmanagement.emailEngine.service.EmailRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ChurchRegistrationRequest {

    private String registrasionTopic = "Welcome to the Church Management Services Platform";
    @NonNull
    @NotBlank
    @NotEmpty
    private String verificationToken;
    private String emailAddress;

    private String message = "Good Day. \n" +
            "An Account has been registered on the Church Management Services platform,\n" +
            "and will welcome you our service --> "+verificationToken+ " <-- is for verification\n" +
            "of your account please ensure to verify your account as soon as possible";

}
