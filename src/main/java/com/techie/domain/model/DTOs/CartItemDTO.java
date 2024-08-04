package com.techie.domain.model.DTOs;

import lombok.*;

import java.math.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDTO {
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal originalPrice;
    private BigDecimal totalPrice;
}
