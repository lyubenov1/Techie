package com.techie.domain.listeners;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Component
public class CartListener {

    @PersistenceContext
    private EntityManager entityManager;

    @PreUpdate
    public void updateGrandTotalAndTimestamp(Cart cart) {
        BigDecimal grandTotal = (BigDecimal) entityManager.createQuery(
                        "SELECT SUM(ci.totalPrice) FROM CartItem ci WHERE ci.cart.id = :cartId")
                .setParameter("cartId", cart.getId())
                .getSingleResult();
        cart.setGrandTotal(grandTotal != null ? grandTotal : BigDecimal.ZERO);
        cart.setUpdatedAt(new Date());
    }
}