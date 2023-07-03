package com.example.churchmanagement.data.repository;

import com.example.churchmanagement.data.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {



}
