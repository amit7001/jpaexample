package com.aks.jpaExample.repo;

import com.aks.jpaExample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
