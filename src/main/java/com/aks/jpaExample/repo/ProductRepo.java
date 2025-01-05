package com.aks.jpaExample.repo;

import com.aks.jpaExample.entity.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductDto,Long> {
}
