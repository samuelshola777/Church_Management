package com.example.churchmanagement.data.model;


import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChurchTokenZ> listOfToken = new ArrayList<>();

    private String password;

    private String phoneNumber;

    private String token;


   

      }
