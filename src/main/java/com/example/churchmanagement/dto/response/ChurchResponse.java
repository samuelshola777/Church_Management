package com.example.churchmanagement.dto.response;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.ChurchType;
import com.example.churchmanagement.data.model.ValidationState;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
@Data
public class ChurchResponse {

    private String message;
    private String churchBranchName;
    private Address address;
    private String phoneNumber;
    private String token;
    private String emailAddress;
    private ChurchType churchType;
    private ValidationState validationState = ValidationState.PENDING;
}
