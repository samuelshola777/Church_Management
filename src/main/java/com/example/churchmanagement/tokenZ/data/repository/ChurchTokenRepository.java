package com.example.churchmanagement.tokenZ.data.repository;

import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ChurchTokenRepository extends JpaRepository<ChurchTokenZ, Long> {

}
