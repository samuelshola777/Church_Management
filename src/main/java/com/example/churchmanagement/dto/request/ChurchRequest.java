package com.example.churchmanagement.dto.request;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.ChurchType;
import com.example.churchmanagement.data.model.ValidationState;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChurchRequest {
    private ValidationState validationState = ValidationState.PENDING;
    private String churchBranchName;
    private ChurchType churchType;
    private LocalDateTime createdAt;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    private String password;
    private String phoneNumber;
    private String emailAddress;
}
