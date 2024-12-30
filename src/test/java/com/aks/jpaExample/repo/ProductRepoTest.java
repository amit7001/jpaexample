package com.aks.jpaExample.repo;

import com.aks.jpaExample.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    ProductRepo productRepo;

    @Test
    void saveMethod() {
        Product product = new Product();
        product.setName("1");
        product.setDescription("231dfs3f");
        product.setSku("12313");
        product.setPrice(BigDecimal.TEN);
        product.setActive(true);
        product.setImageUrl("dsdfsd.png");

        Product saved = productRepo.save(product);

        System.out.println(saved.getId());
        System.out.println(saved.toString());
    }

    @Test
    void updateSaveEntity(){
        Long id=1L;
        Product product=productRepo.findById(id).orElse(null);
        product.setName("ALS");
        product.setDescription("sdasdawewqfsdvvs");
        productRepo.save(product);
    }

    @Test
    void deleteAll(){
        productRepo.deleteAll();
    }
}