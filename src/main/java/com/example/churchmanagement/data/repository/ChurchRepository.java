package com.example.churchmanagement.data.repository;

import com.example.churchmanagement.data.model.ChurchBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChurchRepository extends JpaRepository<ChurchBranch, Long> {
    ChurchBranch findByEmailAddress(String emailAddress);

    ChurchBranch findByPhoneNumber(String phoneNumber);
    @Query("SELECT cb FROM ChurchBranch cb WHERE cb.emailAddress = :email AND cb.validationState != ValidationState.INVALID")
     ChurchBranch findChurchBranchByEmailAddressAndValidationStateNotInvalid(String emailAddress);
       ChurchBranch findChurchBranchByEmailAddress(String email);

      ChurchBranch findByChurchBranchName(String churchName);
}