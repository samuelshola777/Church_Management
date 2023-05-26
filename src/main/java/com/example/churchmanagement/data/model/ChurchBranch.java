package com.example.churchmanagement.data.model;


import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class ChurchBranch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String emailAddress;
    private  String churchBranchName;
    @Enumerated(EnumType.STRING)
    private ChurchType churchType;
    private LocalDateTime createdAt;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
     private Address address;
   // @OneToMany(mappedBy = "token_id", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ChurchTokenZ> listOfToken = new HashSet<>();
    private String password;
    private String phoneNumber;
    private String token;
private int number;

   

      }
