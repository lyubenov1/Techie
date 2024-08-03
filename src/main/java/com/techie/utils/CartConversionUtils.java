package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;

import java.time.format.*;
import java.util.*;

public class CartConversionUtils {

    public static CartDTO convertToDTO(Cart cart) {

        return CartDTO.builder()
                .id(cart.getId())
                .cartItems(convertItemsToDTO(cart.getCartItems()))
                .grandTotal(cart.getGrandTotal())
                .updatedAt(formatDateTime(cart))
                .build();
    }

    private static List<CartItemDTO> convertItemsToDTO(List<CartItem> cartItems) {
        return cartItems.stream().map(CartConversionUtils::convertToItemDTO).toList();
    }

    private static CartItemDTO convertToItemDTO(CartItem item) {
        return CartItemDTO.builder()
                .productId(item.getId())
                .quantity(item.getQuantity())
                .totalPrice(item.getTotalPrice())
                .build();
    }

    private static String formatDateTime(Cart cart) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm", Locale.ENGLISH);
        return cart.getUpdatedAt().format(formatter);
    }
}
