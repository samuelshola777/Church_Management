package com.example.churchmanagement.data.repository;

import com.example.churchmanagement.data.model.Pastor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastorRepository extends JpaRepository< Pastor, Long> {


   Pastor findByEmailAddress(String emailAddress);

   Pastor findByPhoneNumber(String phoneNumber);
}
