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
    public void calculateAverageRating(ProductRating productRating) {
        updateAverageRating(productRating.getProduct());
    }

    public void updateAverageRating(Product product) {
        Double avgRating = entityManager.createQuery(
                        "SELECT AVG(pr.rating) FROM ProductRating pr WHERE pr.product = :product", Double.class)
                .setParameter("product", product)
                .getSingleResult();

        product.setAverageRating(avgRating);
        entityManager.merge(product);
    }
}