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
        product.setName("Amit");
        product.setDescription("11g3d1fg3d");
        product.setSku("fsdsfsdds");
        product.setPrice(BigDecimal.TEN);
        product.setActive(true);
        product.setImageUrl("fwfdffsdf.png");

        Product saved = productRepo.save(product);

        System.out.println(saved.getId());
        System.out.println(saved.toString());
    }

   /* @Test
    void updateSaveEntity(){
        Long id=1L;
        Product product=productRepo.findById(id).orElse(null);
        product.setName("ALS");
        product.setDescription("sdasdawewqfsdvvs");
        productRepo.save(product);
    }*/

    /*@Test
    void deleteAll(){
        productRepo.deleteAll();
    }*/
}