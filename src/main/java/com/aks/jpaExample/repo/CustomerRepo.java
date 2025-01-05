package com.aks.jpaExample.repo;

import com.aks.jpaExample.entity.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerDto,Long> {
}
