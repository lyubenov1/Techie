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

    @Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.wishlists WHERE u.email = :email")
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
