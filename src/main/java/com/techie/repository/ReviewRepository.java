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
            "LEFT JOIN FETCH r.images " +
            "WHERE p.id = :productId")
    Page<Review> findByProductId(@Param("productId") Long productId, Pageable pageable);

    @Query("SELECT r FROM Review r JOIN FETCH r.product WHERE r.id = :reviewId")
    Optional<Review> findByIdWithProduct(@Param("reviewId") Long reviewId);

    @Query("SELECT COALESCE(AVG(r.productRating), 0.0) FROM Review r WHERE r.product.id = :productId")
    Double calculateAverageRatingByProductId(@Param("productId") Long productId);

    @Query("SELECT r FROM Review r " +
            "JOIN FETCH r.product p " +
            "JOIN FETCH r.user " +
            "LEFT JOIN FETCH r.images " +
            "WHERE r.id = :reviewId")
    Optional<Review> findByIdJoinFetch(@Param("reviewId") Long reviewId);

    boolean existsByUserAndProduct(UserEntity user, Product product);
}

