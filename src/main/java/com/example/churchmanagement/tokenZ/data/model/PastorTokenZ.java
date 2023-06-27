package com.example.churchmanagement.tokenZ.data.model;

import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.data.model.Pastor;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
public class PastorTokenZ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pastor pastor;
    private LocalDateTime createAt;
    private LocalDateTime expiredAt;
    private String token;
    @Enumerated(EnumType.STRING)
    private TokenState tokenState;
}
