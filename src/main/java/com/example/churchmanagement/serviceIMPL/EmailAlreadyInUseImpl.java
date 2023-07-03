package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.exception.EmailAlreadyInUseException;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.service.EmailAlreadyInUse;
import com.example.churchmanagement.service.MemberService;
import com.example.churchmanagement.service.PastorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailAlreadyInUseImpl implements EmailAlreadyInUse {

    private final ChurchService churchService;
    public final MemberService memberService;
    private final PastorService pastorService;

    @Override
    public void pastorEmailAlreadyInUse(String email) {
       if (churchService.findChurchBranchByEmailAddress(email) != null ) throw new EmailAlreadyInUseException("email already in use");
    }

}
