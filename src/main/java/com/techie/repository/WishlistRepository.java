package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    boolean existsByUserAndName(UserEntity user, String wishlistName);

    @Query("SELECT w FROM Wishlist w " +
            "LEFT JOIN FETCH w.products p " +
            "LEFT JOIN FETCH p.category " +
            "LEFT JOIN FETCH p.brand " +
            "WHERE w.user.email = :email")
    List<Wishlist> findByUserEmail(@Param("email") String email);

    Optional<Wishlist> findByIdAndUser(Long id, UserEntity user);

    @Query("SELECT w FROM Wishlist w " +
            "LEFT JOIN FETCH w.products " +
            "WHERE w.user = :user AND w.id = :wishlistId")
    Optional<Wishlist> findByIdAndUserJoinFetchProducts(@Param("wishlistId") Long id, @Param("user") UserEntity user);
}
