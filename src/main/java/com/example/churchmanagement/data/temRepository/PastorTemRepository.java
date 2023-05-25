package com.example.churchmanagement.data.temRepository;

import com.example.churchmanagement.data.model.Pastor;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastorTemRepository extends JpaRepository< Pastor, Long> {
    Pastor findByEmailAddress(String emailAddress);
}
