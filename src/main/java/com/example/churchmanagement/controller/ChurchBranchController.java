package com.example.churchmanagement.controller;

import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.service.ChurchService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/api/churchmanagement/")
@RestController
@RequiredArgsConstructor
public class ChurchBranchController {
    @NonNull
    private final ChurchService churchService;

    @PostMapping("create")
    public ResponseEntity<?> createChurchAccount(@RequestBody ChurchRequest churchRequest){
        return churchService.registerANewChurchBranch(churchRequest);
    }

}
