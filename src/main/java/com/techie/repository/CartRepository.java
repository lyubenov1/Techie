package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems ci " +
            "JOIN FETCH ci.product WHERE c.user = :user")
    Optional<Cart> findByUser(@Param("user") UserEntity user);

    @Query("SELECT c FROM Cart c JOIN FETCH c.cartItems ci " +
            "JOIN FETCH ci.product WHERE c.anonymousId = :anonymousId")
    Optional<Cart> findByAnonymousId(@Param("anonymousId") String anonymousId);
}