package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.product.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.math.*;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductService productService,
                       CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }

    @Cacheable(value = "cartCache", key = "#cartId")
    public Cart getOrCreateCart(String cartId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            // Authenticated user
            UserEntity user = (UserEntity) auth.getPrincipal();
            return cartRepository.findByUser(user)
                    .orElseGet(() -> cartRepository.save(new Cart(user)));
        } else {
            // Unauthenticated user
            return cartRepository.findByAnonymousId(cartId)
                    .orElseGet(() -> cartRepository.save(new Cart(cartId)));
        }
    }

    @Transactional
    public CartItem addItem(Cart cart, CartItemDTO itemDTO) {
        Product product = productService.findById(itemDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(itemDTO.getProductId()));

        CartItem newItem = new CartItem();
        newItem.setCart(cart);
        newItem.setProduct(product);
        newItem.setQuantity(itemDTO.getQuantity());
        cart.getCartItems().add(newItem);

        recalculateTotalPrice(newItem);
        recalculateGrandTotal(cart);
        cartRepository.save(cart);
        return newItem;
    }

    @Transactional
    public CartItem updateItem(Cart cart, Long itemId, CartItemDTO itemDTO) {
        CartItem item = cart.getCartItems().stream()
                .filter(i -> i.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new CartItemNotFoundException(itemId));

        item.setQuantity(itemDTO.getQuantity());
        recalculateTotalPrice(item);
        recalculateGrandTotal(cart);
        cartRepository.save(cart);
        return item;
    }


    private void recalculateTotalPrice(CartItem item) {
        if (item.getProduct() != null) {
            BigDecimal priceToUse = item.getProduct().getDiscountedPrice() != null ?
                    item.getProduct().getDiscountedPrice() : item.getProduct().getOriginalPrice();
            item.setTotalPrice(priceToUse.multiply(BigDecimal.valueOf(item.getQuantity())));
        }
    }

    private void recalculateGrandTotal(Cart cart) {
        cart.setGrandTotal(cart.getCartItems().stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public void clearCart(Cart cart) {
    }
}