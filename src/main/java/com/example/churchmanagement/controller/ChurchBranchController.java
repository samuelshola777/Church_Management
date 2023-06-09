package com.example.churchmanagement.controller;

import com.example.churchmanagement.dto.request.ChurchRequest;
import com.example.churchmanagement.dto.response.ChurchResponse;
import com.example.churchmanagement.service.ChurchService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/api/churchmanagement/")
@RestController
@RequiredArgsConstructor
public class ChurchBranchController {
  @NonNull
  private final ChurchService churchService;

    @PostMapping("create")
   public ResponseEntity<ChurchResponse> createChurchAccount(@RequestBody ChurchRequest churchRequest){
        return new ResponseEntity<>(churchService.registerANewChurchBranch(churchRequest), HttpStatus.CREATED);
    }
    @GetMapping("findByName")
    public ResponseEntity<ChurchResponse> findChurchByName(@PathVariable String name){
        return new ResponseEntity<>(churchService.findChurchByName(name),HttpStatus.OK);
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<?> deleteAll(){
        churchService.deleteAllChurchBranch();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
@GetMapping("findByEmailResponse")
    public ResponseEntity<?> findByEmailResponse(@PathVariable String email){
        return new ResponseEntity<>(churchService.findByEmailResponse(email),HttpStatus.FOUND);
}
@GetMapping("findByEmail")
    public ResponseEntity<?> findChurchByEmail(@PathVariable String email){
        return new ResponseEntity<>(churchService.findChurchBranchByEmailAddress(email),HttpStatus.FOUND);
}

}
