package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    boolean existsByUserAndName(UserEntity user, String wishlistName);
}
