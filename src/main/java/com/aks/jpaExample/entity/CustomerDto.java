package com.aks.jpaExample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer", schema = "ecommerce")
public class CustomerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_generator")
    @SequenceGenerator(name = "customer_generator",sequenceName = "customer_product_sequence_name",allocationSize = 1)
    private Long id;
    @Column(nullable = false,length = 254)
    private String name;
    @Column(nullable = false,length = 254)
    private String email;
    @Column(nullable = false,length = 10)
    private int contact;
}
