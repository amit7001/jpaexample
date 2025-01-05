package com.aks.jpaExample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Login", schema = "ecommerce")
public class AuthDto {
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String password;
}
