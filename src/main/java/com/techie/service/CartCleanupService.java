package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.repository.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.time.*;
import java.util.*;

@Service
public class CartCleanupService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartCleanupService(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // Run once a day
    @Transactional
    public void cleanupStaleCarts() {
        LocalDateTime staleThreshold = LocalDateTime.now().minusDays(3);
        List<Cart> staleCarts = cartRepository.findStaleAnonymousCarts(staleThreshold);

        for (Cart cart : staleCarts) {
            cartItemRepository.deleteByCart(cart);
            cartRepository.delete(cart);
        }
    }
}