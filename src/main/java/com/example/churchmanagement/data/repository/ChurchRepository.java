package com.example.churchmanagement.data.repository;

import com.example.churchmanagement.data.model.ChurchBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<ChurchBranch, Long> {
    ChurchBranch findByEmailAddress(String emailAddress);

    ChurchBranch findByPhoneNumber(String phoneNumber);

       ChurchBranch findChurchBranchByEmailAddress(String email);
}
