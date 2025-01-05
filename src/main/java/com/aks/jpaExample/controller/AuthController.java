package com.aks.jpaExample.controller;

import com.aks.jpaExample.model.Login;
import com.aks.jpaExample.model.SignUp;
import com.aks.jpaExample.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    AuthService service;

    @PostMapping("/signup")
    String signup(@RequestBody SignUp signUp) {
        return service.signup(signUp);
    }

    @PostMapping("/login")
    boolean signup(@RequestBody Login login) {
        return service.login(login);
    }

}
