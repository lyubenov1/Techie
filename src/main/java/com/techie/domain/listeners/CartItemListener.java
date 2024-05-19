package com.techie.domain.listeners;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

import java.math.*;

@Component
public class CartItemListener {

    @PersistenceContext
    private EntityManager entityManager;

    @PreUpdate
    public void updateTotalPrice(CartItem cartItem) {
        BigDecimal totalPrice = (BigDecimal) entityManager.createQuery(
                        "SELECT ci.product.originalPrice * ci.quantity FROM CartItem ci WHERE ci.id = :cartItemId")
                .setParameter("cartItemId", cartItem.getId())
                .getSingleResult();
        cartItem.setTotalPrice(totalPrice != null ? totalPrice : BigDecimal.ZERO);
    }
}
