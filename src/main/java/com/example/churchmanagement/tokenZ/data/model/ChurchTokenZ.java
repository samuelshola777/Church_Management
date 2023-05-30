package com.example.churchmanagement.tokenZ.data.model;

import com.example.churchmanagement.data.model.ChurchBranch;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class ChurchTokenZ  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChurchBranch churchBranch;

    private LocalDateTime createAt;
    private LocalDateTime expiredAt;
    private String token;
    @Enumerated(EnumType.STRING)
    private TokenState tokenState;
}
