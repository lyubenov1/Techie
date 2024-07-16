package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    @Query("SELECT u from UserEntity u " +
            "JOIN FETCH u.roles " +
            "WHERE u.email = :email")
    Optional<UserEntity> findByEmailWithRoles(@Param("email") String email);

    @Query("SELECT DISTINCT u FROM UserEntity u " +
            "LEFT JOIN FETCH u.wishlists w " +
            "LEFT JOIN FETCH w.products p " +
            "JOIN FETCH (SELECT pi FROM ProductImage pi WHERE pi.product = p AND pi.isPrimary = true) pi " +
            "WHERE u.email = :email")
    Optional<UserEntity> findByEmailWithWishlists(@Param("email") String email);

    @Query("SELECT u from UserEntity u " +
            "LEFT JOIN FETCH u.addresses " +
            "WHERE u.email = :email")
    Optional<UserEntity> findByEmailWithAddresses(@Param("email") String email);
}
