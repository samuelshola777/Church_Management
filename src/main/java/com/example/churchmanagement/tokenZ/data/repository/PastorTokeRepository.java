package com.example.churchmanagement.tokenZ.data.repository;

import com.example.churchmanagement.data.model.Pastor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastorTokeRepository extends JpaRepository<Pastor, Long> {
}
