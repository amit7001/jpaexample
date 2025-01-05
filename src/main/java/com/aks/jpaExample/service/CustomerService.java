package com.aks.jpaExample.service;

import com.aks.jpaExample.entity.CustomerDto;
import com.aks.jpaExample.repo.AuthRepo;
import com.aks.jpaExample.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;


    public List<CustomerDto> getAllCustomer() {
        return customerRepo.findAll();

    }

}
