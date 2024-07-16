package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.lang.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Repository
public interface ProductRepositoryDummy extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN FETCH p.category JOIN FETCH p.brand " +
            "JOIN FETCH p.productImages WHERE p.category.id = :categoryId")
    List<Product> findByCategoryId(Long categoryId);

    @Query("SELECT p FROM Product p JOIN FETCH p.category " +
            "JOIN FETCH p.brand JOIN FETCH p.productImages " +
            "WHERE LOWER(p.name) = LOWER(:name)")
    Optional<Product> findByNameIgnoreCase(@Param("name") String name);

    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p JOIN FETCH p.category JOIN FETCH p.brand " +
            "JOIN FETCH p.productImages " +
            "WHERE p.category = :category " +
            "AND p.originalPrice BETWEEN :minPrice AND :maxPrice " +
            "AND p.id <> :id")
    List<Product> findByCategoryAndOriginalPriceBetweenAndIdNot(@Param("category") Category category, @Param("minPrice") BigDecimal minPrice,
                                                                @Param("maxPrice") BigDecimal maxPrice, @Param("id") Long id);

    @Query("SELECT p FROM Product p JOIN FETCH p.category " +
            "JOIN FETCH p.brand JOIN FETCH p.productImages " +
            "WHERE p.name LIKE %:query%")
    List<Product> findByNameContaining(@Param("query") String query);

    @Query("SELECT p FROM Product p JOIN FETCH p.category " +
            "JOIN FETCH p.brand JOIN FETCH p.productImages " +
            "WHERE p.name LIKE %:query% ORDER BY p.averageRating DESC")
    List<Product> findByNameContainingAndRating(@Param("query") String query, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN FETCH p.category " +
            "JOIN FETCH p.brand JOIN FETCH p.productImages " +
            "WHERE p.name LIKE %:query% " +
            "AND (:categoryName IS NULL OR p.category.name = :categoryName) " +
            "ORDER BY p.averageRating DESC")
    List<Product> findByNameContainingAndCategory(@Param("query") String query,
                                                  @Param("categoryName") String categoryName,
                                                  Pageable pageable);

    @Query("SELECT p FROM Product p JOIN FETCH p.category " +
            "JOIN FETCH p.brand JOIN FETCH p.productImages " +
            "WHERE p.id = :id")
    @NonNull
    Optional<Product> findById(@Param("id") @NonNull Long id);
}