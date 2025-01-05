package com.aks.jpaExample.service;

import com.aks.jpaExample.Exception.CustomException;
import com.aks.jpaExample.entity.ProductDto;
import com.aks.jpaExample.model.Product;
import com.aks.jpaExample.repo.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<Product> getAllProduct() {
        List<ProductDto> productDtoList = repo.findAll();
        Function<ProductDto, Product> productDtoProductFunction = productDto -> new Product(productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getPrice());
        return productDtoList.stream().map(productDtoProductFunction).toList();
    }

    public ProductDto getProductById(String productId) throws CustomException {
        try {
            return repo.findById(Long.parseLong(productId)).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException e) {
            throw new CustomException("Not Product found");
        }
    }

    public String saveProduct(Product product) {
        ProductDto productDto= new ProductDto();
        productDto.setName(product.getProductName());
        productDto.setDescription(product.getProductDescription());
        productDto.setPrice(product.getPrice());
        productDto.setActive(true);
        productDto.setSku("Hundred");
        ProductDto saved = repo.save(productDto);
        return saved.getId().toString();
    }

    public void deleteProduct(String productId) {
        repo.deleteById(Long.parseLong(productId));
    }

    public ProductDto updateProduct(ProductDto product) throws CustomException {
        try {
            ProductDto updatedProduct = repo.findById(product.getId()).orElseThrow(EntityNotFoundException::new);
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setActive(product.isActive());
            updatedProduct.setSku(product.getSku());
            updatedProduct.setName(product.getName());
            updatedProduct.setImageUrl(product.getImageUrl());
            updatedProduct.setPrice(product.getPrice());
            repo.save(updatedProduct);
            return updatedProduct;
        } catch (EntityNotFoundException e) {
            throw new CustomException("Not Product found with given id ");
        }
    }
}
