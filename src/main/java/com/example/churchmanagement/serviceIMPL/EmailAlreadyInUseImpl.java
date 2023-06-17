package com.example.churchmanagement.serviceIMPL;

import com.example.churchmanagement.exception.EmailAlreadyInUseException;
import com.example.churchmanagement.service.ChurchService;
import com.example.churchmanagement.service.EmailAlreadyInUse;
import com.example.churchmanagement.service.PastorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class EmailAlreadyInUseImpl implements EmailAlreadyInUse {

    private ChurchService churchService;
    private PastorService pastorService;

    @Override
    public void emailAlreadyInUse(String email) {
       if (churchService.findChurchByName(email) != null ) throw new EmailAlreadyInUseException("email already in use");

    }
}
