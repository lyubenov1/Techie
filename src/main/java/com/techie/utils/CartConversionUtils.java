package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;

import java.math.*;
import java.time.format.*;
import java.util.*;

public class CartConversionUtils {

    public static CartDTO convertToDTO(Cart cart) {
        List<CartItemDTO> cartItemDTOs = convertItemsToDTO(cart.getCartItems());

        BigDecimal nonDiscountTotal = cartItemDTOs.stream()
                .map(CartItemDTO::getOriginalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return CartDTO.builder()
                .id(cart.getId())
                .cartItems(cartItemDTOs)
                .grandTotal(cart.getGrandTotal())
                .updatedAt(formatDateTime(cart))
                .nonDiscountTotal(nonDiscountTotal)
                .build();
    }

    private static List<CartItemDTO> convertItemsToDTO(List<CartItem> cartItems) {
        return cartItems.stream().map(CartConversionUtils::convertToItemDTO).toList();
    }

    public static CartItemDTO convertToItemDTO(CartItem item) {
        return CartItemDTO.builder()
                .id(item.getId())
                .quantity(item.getQuantity())
                .originalPrice(item.getProduct().getOriginalPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .totalPrice(item.getTotalPrice())
                .build();
    }

    private static String formatDateTime(Cart cart) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm", Locale.ENGLISH);
        return cart.getUpdatedAt().format(formatter);
    }
}
