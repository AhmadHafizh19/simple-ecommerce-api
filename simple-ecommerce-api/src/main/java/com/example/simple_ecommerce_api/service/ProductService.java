package com.example.simple_ecommerce_api.service;

import com.example.simple_ecommerce_api.model.Product;
import com.example.simple_ecommerce_api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }

//    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    public Product update(Long id, Product product) {
        Product p = productRepo.findById(id).orElseThrow();
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setStock(product.getStock());
        return productRepo.save(p);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

}