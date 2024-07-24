package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r " +
            "JOIN FETCH r.product p " +
            "JOIN FETCH r.user " +
            "LEFT JOIN FETCH r.imageUrls " +
            "WHERE p.id = :productId")
    Page<Review> findByProductId(@Param("productId") Long productId, Pageable pageable);

    boolean existsByUserAndProduct(UserEntity user, Product product);

    @Query("SELECT r FROM Review r JOIN FETCH r.product WHERE r.id = :reviewId")
    Review findByIdWithProduct(@Param("reviewId") Long reviewId);

    @Query("SELECT AVG(r.productRating) FROM Review r WHERE r.product.id = :productId")
    double calculateAverageRatingByProductId(@Param("productId") Long productId);

    @Query("SELECT r FROM Review r " +
            "JOIN FETCH r.product p " +
            "JOIN FETCH r.user " +
            "LEFT JOIN FETCH r.imageUrls " +
            "WHERE r.id = :reviewId")
    Optional<Review> findByIdJoinFetch(@Param("reviewId") Long reviewId);
}

