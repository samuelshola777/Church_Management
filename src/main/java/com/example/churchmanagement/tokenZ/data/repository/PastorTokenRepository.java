package com.example.churchmanagement.tokenZ.data.repository;

import com.example.churchmanagement.data.model.Pastor;
import com.example.churchmanagement.tokenZ.data.model.PastorTokenZ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastorTokenRepository extends JpaRepository<PastorTokenZ, Long> {
}
