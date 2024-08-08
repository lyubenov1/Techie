package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class OrderConversionUtils {
    public static OrderDTO convertToDTO(Order order) {
        List<OrderItemDTO> orderItemDTOs = convertItemsToDTO(order.getOrderItems());

        return OrderDTO.builder()
                .orderId(order.getId())
                .userEmail(order.getUserEmail())
                .createdAt(formatDateTime(order.getCreatedAt()))
                .paymentMethod(order.getPaymentMethod().toString())
                .address(order.getDeliveryAddress() != null ? order.getDeliveryAddress().getName() : order.getAnonymousAddress())
                .grandTotal(order.getGrandTotal())
                .orderItems(orderItemDTOs)
                .build();
    }

    private static List<OrderItemDTO> convertItemsToDTO(List<OrderItem> orderItems) {
        return orderItems.stream().map(OrderConversionUtils::convertToItemDTO).toList();
    }

    private static OrderItemDTO convertToItemDTO(OrderItem item) {
        return OrderItemDTO.builder()
                .id(item.getId())
                .quantity(item.getQuantity())
                .totalPrice(item.getTotalPrice())
                .build();
    }

    private static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm", Locale.ENGLISH);
        return dateTime.format(formatter);
    }

}
