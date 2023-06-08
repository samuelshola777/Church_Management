package com.example.churchmanagement.emailEngine.service.EmailRequest;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class GenerateTokenRequest {
    @NonNull
    private String token;
    @NonNull
    private String receiverEmail;
    private String tokenHeader = "==>  \uD83E\uDD2A\uD83E\uDD2A\uD83E\uDD2A\uD83E\uDD2A ACTIVITY TOKEN  \uD83E\uDD2A\uD83E\uDD2A\uD83E\uDD2A\uD83E\uDD2A <==";
    private String tokenMessage = "your event token ==> ";
}
