package com.aks.jpaExample.service;

import com.aks.jpaExample.Exception.CustomException;
import com.aks.jpaExample.entity.Product;
import com.aks.jpaExample.repo.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo  repo;

    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    public Product getProductById(String productId) throws CustomException {
        try{
        return repo.findById(Long.parseLong(productId)).orElseThrow(EntityNotFoundException::new);}
        catch (EntityNotFoundException e){
            throw new CustomException("Not Product found");
        }
    }

    public String saveProduct(Product product) {
        Product saved= repo.save(product);
        return saved.getId().toString();
    }

    public void deleteProduct(String productId) {
        repo.deleteById(Long.parseLong(productId));
    }

    public Product updateProduct(Product product) throws CustomException {
        try{
        Product updatedProduct= repo.findById(product.getId()).orElseThrow(EntityNotFoundException::new);
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setActive(product.isActive());
            updatedProduct.setSku(product.getSku());
            updatedProduct.setName(product.getName());
            updatedProduct.setImageUrl(product.getImageUrl());
            updatedProduct.setPrice(product.getPrice());
            repo.save(updatedProduct);
            return updatedProduct;
        }
        catch (EntityNotFoundException e){
            throw new CustomException("Not Product found with given id ");
        }
    }
}
