package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.*;
import com.techie.exceptions.product.*;
import com.techie.repository.*;
import com.techie.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.math.*;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;
    private final UserService userService;

    @Autowired
    public CartService(CartRepository cartRepository, ProductService productService,
                       CartItemRepository cartItemRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
    }

    @Cacheable(value = "cartCache", key = "#cartId")
    public Cart getOrCreateCart(String cartId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            // Authenticated user
            User authUser = (User) auth.getPrincipal();
            UserEntity user = userService.findByUsernameNoFetches(authUser.getUsername());
            return cartRepository.findByUser(user)
                    .orElseGet(() -> cartRepository.save(new Cart(user)));
        } else {
            // Unauthenticated user
            return cartRepository.findByAnonymousId(cartId)
                    .orElseGet(() -> cartRepository.save(new Cart(cartId)));
        }
    }

    @Transactional
    public CartItemDTO addItem(Cart cart, CartItemDTO itemDTO)
                                throws ProductNotFoundException, NotEnoughInStockException{
        Product product = productService.findById(itemDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(itemDTO.getProductId()));

        boolean productAlreadyInCart = cart.getCartItems().stream()
                .anyMatch(cartItem -> cartItem.getProduct().getId().equals(product.getId()));

        if (productAlreadyInCart) {
            throw new ProductAlreadyInCartException("Product is already added to your cart. You can adjust the quantity before checkout");
        }

        if (product.getStock() < 1) {
            throw new NotEnoughInStockException();
        }

        productService.updateStockQuantity(product, 1, false);

        CartItem newItem = new CartItem();
        newItem.setCart(cart);
        newItem.setProduct(product);
        newItem.setQuantity(1);
        cart.getCartItems().add(newItem);


        calculateTotalPrice(newItem);
        calculateGrandTotal(cart);

        cartItemRepository.save(newItem);
        cartRepository.save(cart);
        return CartConversionUtils.convertToItemDTO(newItem);
    }

    @Transactional
    public void updateItem(Cart cart, CartItemDTO itemDTO)
                            throws ObjectNotFoundException, NotEnoughInStockException {
        Product product = productService.findById(itemDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(itemDTO.getProductId()));

        CartItem item = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException("CartItem not found"));

        if (item.getQuantity() < itemDTO.getQuantity()) {
            int quantityToRemove = itemDTO.getQuantity() - item.getQuantity();
            if (product.getStock() < quantityToRemove) {
                throw new NotEnoughInStockException();
            }
            productService.updateStockQuantity(product, quantityToRemove, false);
        } else if (item.getQuantity() > itemDTO.getQuantity()) {
            int quantityToAdd = item.getQuantity() - itemDTO.getQuantity();
            productService.updateStockQuantity(product, quantityToAdd, true);
        }

        item.setQuantity(itemDTO.getQuantity());
        calculateTotalPrice(item);
        calculateGrandTotal(cart);

        cartItemRepository.save(item);
        cartRepository.save(cart);
    }


    public void calculateTotalPrice(CartItem item) {
        if (item.getProduct() != null) {
            BigDecimal priceToUse = item.getProduct().getDiscountedPrice() != null ?
                    item.getProduct().getDiscountedPrice() : item.getProduct().getOriginalPrice();
            item.setTotalPrice(priceToUse.multiply(BigDecimal.valueOf(item.getQuantity())));
        }
    }

    public void calculateGrandTotal(Cart cart) {
        cart.setGrandTotal(cart.getCartItems().stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public CartDTO getCartDTO(Cart cart) {
        return CartConversionUtils.convertToDTO(cart);
    }


}