package com.techie.events;

import lombok.*;

import java.math.*;

@Getter
public record ProductPriceChangeEvent(Long productId, BigDecimal newPrice, boolean isDiscount) {
}