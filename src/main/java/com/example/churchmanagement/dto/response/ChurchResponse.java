package com.example.churchmanagement.dto.response;

import com.example.churchmanagement.data.model.Address;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChurchResponse {

    private String message;
    private String churchBranchName;
    private Address address;
}
