package com.example.churchmanagement.dto.request;

import com.example.churchmanagement.data.model.Address;
import com.example.churchmanagement.data.model.ChurchBranch;
import com.example.churchmanagement.data.model.DateZ;
import com.example.churchmanagement.data.model.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class MemberRequest {
    private  String firstName , lastName;

    private String phoneNumber;

    private String emailAddress;

    private String profile_picture;
    private Address address;

    private Role role = Role.MEMBER;
    private String occupation;
    private String churchName;
    private String password;
    private DateZ dateOfBirth;
    private ChurchBranch churchBranch;
}
