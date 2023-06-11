package com.example.churchmanagement.data.repository;

import com.example.churchmanagement.data.model.ChurchBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChurchRepository extends JpaRepository<ChurchBranch, Long> {
    ChurchBranch findByEmailAddress(String emailAddress);
    ChurchBranch findByPhoneNumber(String phoneNumber);

    ChurchBranch findByChurchBranchName(String churchName);

    void deleteAllChurchTokenZByEmailAddress(String mail);
}