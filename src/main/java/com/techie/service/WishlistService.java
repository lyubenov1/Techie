package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.exceptions.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;


@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
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

}