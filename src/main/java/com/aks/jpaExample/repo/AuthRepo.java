package com.aks.jpaExample.repo;

import com.aks.jpaExample.entity.AuthDto;
import com.aks.jpaExample.entity.CustomerDto;
import com.aks.jpaExample.entity.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<AuthDto,Long> {
}
