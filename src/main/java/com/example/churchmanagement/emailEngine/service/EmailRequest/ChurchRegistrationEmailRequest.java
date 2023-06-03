package com.example.churchmanagement.emailEngine.service.EmailRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChurchRegistrationEmailRequest {

    private String registrasionTopic = "Welcome to the Church Management Services Platform";
    @NotBlank
    @NotEmpty
    private String verificationToken;

    @NotBlank
    @NotEmpty
    private String emailAddress;

    private String message = "Good Day. \n" +
            "An Account has been registered on the Church Management Services platform,\n" +
            "and will welcome you our service --> "+verificationToken+ " <-- is for verification\n" +
            "of your account please ensure to verify your account as soon as possible";

}
