package com.example.churchmanagement.dto.request;

import lombok.Data;

@Data
public class ChangeChurchAddressRequest {
    private String churchBranchEmailAddress;
    private String state;
    private String streetName;
    private String localGovernment;
    private String houseNumber;
}
