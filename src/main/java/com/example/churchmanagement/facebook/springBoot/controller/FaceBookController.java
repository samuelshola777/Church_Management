package com.example.churchmanagement.facebook.springBoot.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("api/facebook/")
public class FaceBookController {

    @GetMapping("post")
    public String postToFaceBook() throws IOException {
        Resource resource = new ClassPathResource("com/example/facebook/theButtonFile.html");
        byte[] bytes = Files.readAllBytes(resource.getFile().toPath());
        return new String(bytes, StandardCharsets.UTF_8);

    }

@GetMapping("auth")
    public String testController(Principal principal){
    Map<String, Object> authDetails = (Map<String, Object>) ((OAuth2Authentication)principal)
            .getUserAuthentication()
            .getDetails();
    Object key;
    String userName = (String) authDetails.get("name");

        return "my name is samuel  => "+userName;
    }

}
