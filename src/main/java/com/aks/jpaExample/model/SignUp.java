package com.aks.jpaExample.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
    private String customerName;
    private String email;
    private int contact;
    private String password;
}
