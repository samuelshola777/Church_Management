package com.example.churchmanagement.facebook.springBoot.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

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
    public String testController(){

        return "my name is samuel shola";
    }

}
