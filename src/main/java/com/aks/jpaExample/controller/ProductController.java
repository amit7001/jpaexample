package com.aks.jpaExample.controller;

import com.aks.jpaExample.Exception.CustomException;
import com.aks.jpaExample.entity.Product;
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
    Product getProductById(@PathVariable String productId) throws CustomException {
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
    Product updateProduct(@RequestBody Product product) throws CustomException {
        return service.updateProduct(product);
    }
}
