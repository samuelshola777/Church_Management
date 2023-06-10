package com.example.churchmanagement.tokenZ.data.model;

import com.example.churchmanagement.data.model.ChurchBranch;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
public class ChurchTokenZ  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(
            foreignKey = @ForeignKey(
                    foreignKeyDefinition = "foreign key (church_branch_id) references church_branch (id) ON DELETE CASCADE"
            )
    )
    private ChurchBranch churchBranch;

    private LocalDateTime createAt;

    private LocalDateTime expiredAt;

    private String token;

    @Enumerated(EnumType.STRING)

    private TokenState tokenState;
}
