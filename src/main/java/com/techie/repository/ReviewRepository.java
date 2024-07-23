package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r " +
            "JOIN FETCH r.product p " +
            "JOIN FETCH r.user " +
            "LEFT JOIN FETCH r.imageUrls " +
            "WHERE p.id = :productId")
    Page<Review> findByProductId(@Param("productId") Long productId, Pageable pageable);

    boolean existsByUserAndProduct(UserEntity user, Product product);
}

