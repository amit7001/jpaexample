package com.aks.jpaExample.controller;

import com.aks.jpaExample.Exception.CustomException;
import com.aks.jpaExample.entity.ProductDto;
import com.aks.jpaExample.model.Product;
import com.aks.jpaExample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/product")
    List<Product> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping("/product/{productId}")
    ProductDto getProductById(@PathVariable String productId) throws CustomException {
        return service.getProductById(productId);
    }

    @PostMapping("/product")
    String saveProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @DeleteMapping("/product/{productId}")
    void deleteProduct(@PathVariable String productId) {
        service.deleteProduct(productId);
    }

    @PutMapping("/product")
    ProductDto updateProduct(@RequestBody ProductDto product) throws CustomException {
        return service.updateProduct(product);
    }
}
