package com.techie.domain.listeners;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Component
public class ProductRatingListener {

    @PersistenceContext
    private EntityManager entityManager;

    @PostPersist
    @PostUpdate
    @PostRemove
    @Transactional
    public void calculateAverageRating(Review review) {
        updateAverageRating(review.getProduct());
    }

    public void updateAverageRating(Product product) {
        Double avgRating = entityManager.createQuery(
                        "SELECT AVG(r.productRating) FROM Review r WHERE r.product = :product", Double.class)
                .setParameter("product", product)
                .getSingleResult();

        product.setAverageRating(avgRating);
        entityManager.merge(product);
    }
}