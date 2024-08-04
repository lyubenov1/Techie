package com.techie.events;

import java.math.*;

public record ProductPriceChangeEvent(Long productId, BigDecimal newPrice, boolean isDiscount) {
}