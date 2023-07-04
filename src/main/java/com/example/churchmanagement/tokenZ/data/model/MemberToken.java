package com.example.churchmanagement.tokenZ.data.model;

import com.example.churchmanagement.data.model.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class MemberToken {

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    private LocalDateTime createAt;

    private LocalDateTime expiredAt;

    private String token;

    @Enumerated(EnumType.STRING)

    private TokenState tokenState;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
