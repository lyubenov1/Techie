package com.techie.service;

import com.techie.domain.entities.Product;
import com.techie.exceptions.ProductNotFoundException;
import com.techie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findByName(String phoneModel) {
        Optional<Product> optionalProduct = this.productRepository.findByName(phoneModel);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new ProductNotFoundException(phoneModel + " was not found!");
        }
    }

    public List<String> getBrandsByCategory(String category) {
        return productRepository.findDistinctBrandsByCategory(category);
    }
}
