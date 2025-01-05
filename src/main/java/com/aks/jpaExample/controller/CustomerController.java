package com.aks.jpaExample.controller;

import com.aks.jpaExample.entity.CustomerDto;
import com.aks.jpaExample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping ("/getAllCustomer")
    List<CustomerDto> getAllCustomer() {
        return service.getAllCustomer();
    }


}
