package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.entities.products.*;
import com.techie.domain.model.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<ProductDTO> getProductsByCategory(String categoryName) {
        List<Product> products = productRepository.findByCategoryName(categoryName);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductByName(String name) {
        return productRepository.findByName(name)
                .map(this::convertToDTO);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .originalPrice(product.getOriginalPrice())
                .categoryName(product.getCategory().getName())
                .brandName(product.getBrand().getName())
                .imageUrls(product.getProductImages().stream().map(ProductImage::getUrl).collect(Collectors.toList()))
                .description(product.getDescription())
                .averageRating(product.getAverageRating())
                .build();

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;

            return SmartphoneDTO.builder()
                    .product(productDTO)
                    .screenSize(smartphone.getScreenSize())
                    .screenResolution(smartphone.getScreenResolution())
                    .ram(smartphone.getRam())
                    .storage(smartphone.getStorage())
                    .batteryCapacity(smartphone.getBatteryCapacity())
                    .frontCamera(smartphone.getFrontCamera())
                    .rearCamera(smartphone.getRearCamera())
                    .refreshRate(smartphone.getRefreshRate())
                    .color(smartphone.getColor())
                    .operatingSystem(smartphone.getOperatingSystem())
                    .yearOfRelease(smartphone.getYearOfRelease())
                    .build();
        }

        return productDTO;
    }
}
