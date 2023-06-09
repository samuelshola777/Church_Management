package com.example.churchmanagement.controller;

import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.dto.response.ChurchResponse;
import com.example.churchmanagement.service.ChurchService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
   public ResponseEntity<ChurchResponse> createChurchAccount(ChurchRequest churchRequest){
        return new ResponseEntity<>(churchService.registerANewChurchBranch(churchRequest), HttpStatus.CREATED)
    }

}
