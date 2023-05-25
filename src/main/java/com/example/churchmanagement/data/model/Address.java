package com.example.churchmanagement.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String streetName;
    private String state;
    private String localGovernment;
    private String houseNumber;


}
