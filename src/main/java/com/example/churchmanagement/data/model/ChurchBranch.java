package com.example.churchmanagement.data.model;


import com.example.churchmanagement.tokenZ.data.model.ChurchTokenZ;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
    @Column(unique = true, nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
   private ValidationState validationState = ValidationState.PENDING;

private String emailAddress;

    private  String churchBranchName;

    @Enumerated(EnumType.STRING)
    private ChurchType churchType;

    private LocalDateTime createdAt;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
     private Address address;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "churchBranch", orphanRemoval = true)
    private final List<ChurchTokenZ> listOfToken  = new ArrayList<>();

    private String password;
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Pastor pastor;

    private String phoneNumber;
    @OneToMany( cascade = CascadeType.DETACH, mappedBy = "churchBranch", orphanRemoval = true)
private final List<Member> listOfMembers = new ArrayList<>();
    private String token;
//    @Bean
//    @PostConstruct
//    public void initializisation(){
//    this.listOfToken = new ArrayList<>();
//}
//    public List<ChurchTokenZ> getListOfToken() {
//        return listOfToken;
//    }
    public void addToken(ChurchTokenZ token) {
        listOfToken.add(token);
    }
}
