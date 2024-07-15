package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.stream.*;


@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ProductService productService;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, ProductService productService) {
        this.wishlistRepository = wishlistRepository;
        this.productService = productService;
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
        return WishlistDTO.builder()
                .id(wishlist.getId())
                .name(wishlist.getName())
                .products(wishlist.getProducts().stream()
                        .map(productService::convertToDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}