package com.example.churchmanagement.data.temRepository;

import com.example.churchmanagement.data.model.ChurchBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchTempoRepo extends JpaRepository<ChurchBranch, Long> {


    ChurchBranch findByChurchBranchName(String churchName);

    ChurchBranch findByPhoneNumber(String phoneNumber);
}
