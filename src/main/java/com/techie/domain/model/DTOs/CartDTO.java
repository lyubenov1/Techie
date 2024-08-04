package com.techie.domain.model.DTOs;

import lombok.*;

import java.math.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private Long id;
    private List<CartItemDTO> cartItems;
    private String updatedAt;
    private BigDecimal nonDiscountTotal;
    private BigDecimal grandTotal;
}
