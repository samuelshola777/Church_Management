package com.example.churchmanagement.controller;

import com.example.churchmanagement.dto.request.ChangeChurchAddressRequest;
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
    @DeleteMapping("deleteAll")
    public ResponseEntity<?> deleteAll(){
        churchService.deleteAllChurchBranch();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
@GetMapping("find/{email}")
    public ResponseEntity<ChurchResponse> findByEmailResponse(@PathVariable String email){
        return new ResponseEntity<>(churchService.findByEmailResponse(email),HttpStatus.FOUND);
}
@GetMapping("findByEmail{email}")
    public ResponseEntity<?> findChurchByEmail(@PathVariable String email){
        return new ResponseEntity<>(churchService.findChurchBranchByEmailAddress(email),HttpStatus.FOUND);
}
@GetMapping("findByName{churchName}")
    public ResponseEntity< ? > findChurchByName(@PathVariable String churchName) {
        return new ResponseEntity<>(churchService.findChurchByName(churchName),HttpStatus.FOUND);
    }
    @PutMapping("changeChurchName")
public ResponseEntity<?> changeChurchName(@PathVariable String email, @PathVariable String churchName) {
        return new ResponseEntity<>(churchService.changeChurchBranchName(email, churchName),HttpStatus.OK);
    }
    @PutMapping("changeChurchAddress")
    public ResponseEntity<?> changeChurchAddress(@RequestBody ChangeChurchAddressRequest changeChurchAddressRequest){
        return new ResponseEntity<>(churchService.changeChurchAddress(changeChurchAddressRequest),HttpStatus.OK);
    }
    @PutMapping("changePassword")
    public ResponseEntity<?> changePassword(@PathVariable String email, @PathVariable String newPassword){
        return new ResponseEntity<>(churchService.changeChurchPassword(email, newPassword),HttpStatus.OK);
    }
}
