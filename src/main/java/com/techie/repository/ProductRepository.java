package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN FETCH p.category JOIN FETCH p.brand " +
            "JOIN FETCH p.productImages WHERE p.category.name = :categoryName")
    List<Product> findByCategoryName(String categoryName);

    @Query("SELECT p FROM Product p WHERE p.category = :category OR p.category.parent = :category")
    List<Product> findByCategoryAndChildren(@Param("category") Category category);

    Optional<Product> findByName(String name);
}