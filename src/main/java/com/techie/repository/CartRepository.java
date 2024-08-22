package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c LEFT JOIN FETCH c.cartItems ci " +
            "LEFT JOIN FETCH ci.product WHERE c.user.email = :email")
    Optional<Cart> findByUserEmail(@Param("email") String email);

    @Query("SELECT c FROM Cart c LEFT JOIN FETCH c.cartItems ci " +
            "LEFT JOIN FETCH ci.product WHERE c.anonymousId = :anonymousId")
    Optional<Cart> findByAnonymousId(@Param("anonymousId") String anonymousId);

    @Query("SELECT c FROM Cart c WHERE c.user IS NULL AND c.updatedAt < :threshold")
    List<Cart> findStaleAnonymousCarts(@Param("threshold") LocalDateTime threshold);

    @Query("SELECT c FROM Cart c LEFT JOIN FETCH c.cartItems WHERE :cartItem MEMBER OF c.cartItems")
    Cart findByCartItem(@Param("cartItem") CartItem cartItem);
}