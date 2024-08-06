package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class OrderConversionUtils {
    public static OrderDTO convertToDTO(Order order) {

        return OrderDTO.builder()
                .orderId(order.getId())
                .userEmail(order.getUserEmail())
                .createdAt(formatDateTime(order.getCreatedAt()))
                .build();
    }

    private static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm", Locale.ENGLISH);
        return dateTime.format(formatter);
    }

}
