package com.techie.domain.model.DTOs;

import lombok.*;

import java.math.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDTO {
    private Long productId;
    private int quantity;
    private BigDecimal totalPrice;
}
