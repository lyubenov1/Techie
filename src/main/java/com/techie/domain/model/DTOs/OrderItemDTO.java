package com.techie.domain.model.DTOs;

import lombok.*;

import java.math.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private Long id;
    private ProductDTO product;
    private int quantity;
    private BigDecimal totalPrice;
}
