package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.exception.EmailAlreadyInUseException;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.service.EmailAlreadyInUse;
import com.example.churchmanagement.service.PastorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailAlreadyInUseImpl implements EmailAlreadyInUse {

    private ChurchService churchService;


    @Override
    public void pastorEmailAlreadyInUse(String email) {
       if (churchService.findChurchByName(email) != null ) throw new EmailAlreadyInUseException("email already in use");
    }

    @Override
    public void churchEmailAlreadyInUse(String email) {

    }
}
