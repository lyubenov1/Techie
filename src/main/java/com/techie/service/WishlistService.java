package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;


@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ProductService productService;
    private final ProductImageRepository productImageRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, ProductService productService,
                           ProductImageRepository productImageRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productService = productService;
        this.productImageRepository = productImageRepository;
    }

    public void createWishlist(UserEntity user, String wishlistName) {
        boolean wishlistExists = wishlistRepository.existsByUserAndName(user, wishlistName);
        if (wishlistExists) {
            throw new DuplicateWishlistException("You already have a wishlist named '" + wishlistName + "'.");
        }

        Wishlist wishlist = new Wishlist();
        wishlist.setName(wishlistName);
        user.addWishlist(wishlist);

        wishlistRepository.save(wishlist);
    }

    public WishlistDTO convertToDto(Wishlist wishlist) {
        List<Product> products = wishlist.getProducts();
        setImageForEachProduct(products);  // Since we cannot directly fetch the productImages list from the database due to MultipleBagFetchException.
                                           // This assignment affects only the current instance of the Product object in memory
                                           // and does not persistently alter the default or existing data in the productImages table

        return WishlistDTO.builder()
                .id(wishlist.getId())
                .name(wishlist.getName())
                .products(products.stream()
                        .map(productService::convertToDTO)
                        .toList())
                .build();
    }

    private void setImageForEachProduct(List<Product> products) {
        products.forEach(product ->
                product.setProductImages(productImageRepository.findPrimaryImagesByProductId(product.getId())));
    }

    public Wishlist findById(Long id) {
        return wishlistRepository.findById(id)
                .orElseThrow(() -> new WishlistNotFoundException(id));
    }

    public List<WishlistDTO> getAndConvertWishlists(String username) {
        return wishlistRepository.findByUserEmail(username)
                .stream()
                .map(this::convertToDto)
                .sorted(Comparator.comparing(WishlistDTO::getId))
                .toList();
    }

    public void deleteWishlist(UserEntity user, Long id) {
    }
}