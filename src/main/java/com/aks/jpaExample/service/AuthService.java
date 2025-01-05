package com.aks.jpaExample.service;

import com.aks.jpaExample.entity.AuthDto;
import com.aks.jpaExample.entity.CustomerDto;
import com.aks.jpaExample.model.Login;
import com.aks.jpaExample.model.SignUp;
import com.aks.jpaExample.repo.AuthRepo;
import com.aks.jpaExample.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    AuthRepo authRepo;

    @Autowired
    CustomerRepo customerRepo;


    public String signup(SignUp signUp) {
        CustomerDto customerDto= new CustomerDto();
        customerDto.setName(signUp.getCustomerName());
        customerDto.setEmail(signUp.getEmail());
        customerDto.setContact(signUp.getContact());
        CustomerDto savedDto= customerRepo.save(customerDto);
        AuthDto authDto= new AuthDto();
        authDto.setId(savedDto.getId());
        authDto.setPassword(signUp.getPassword());
        authRepo.save(authDto);
        return savedDto.getId().toString();
    }

    public boolean login(Login login) {
        Optional<AuthDto> authDetails= authRepo.findById((long) login.getId());
        return authDetails.map(authDto -> authDto.getPassword().equals(login.getPassword())).orElse(false);
    }
}
