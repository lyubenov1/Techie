package com.techie.domain.model.DTOs;

import lombok.*;

import java.math.*;
import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long orderId;
    private String userEmail;
    private String createdAt;
    private String paymentMethod;
    private String address;
    private BigDecimal grandTotal;
    private List<OrderItemDTO> orderItems;
}
