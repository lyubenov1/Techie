package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.domain.*;
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
    Optional<UserEntity> findByEmailFetchRoles(@Param("email") String email);

    @Query("SELECT u FROM UserEntity u " +
            "JOIN FETCH u.roles " +
            "LEFT JOIN FETCH u.wishlists " +
            "WHERE u.email = :email")
    Optional<UserEntity> findByEmailFetchRolesAndWishlists(@Param("email") String email);

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    Optional<UserEntity> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.roles WHERE u.email LIKE %:query%")
    List<UserEntity> findByEmailContaining(@Param("query") String query);

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.roles " +
            "WHERE u.email LIKE %:query% AND u.id NOT IN " +
            "(SELECT b.user.id FROM Blacklist b)")
    List<UserEntity> findByEmailContainingNotBlacklisted(@Param("query") String query);

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.roles")
    List<UserEntity> findAllUsers();

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.roles WHERE u.id " +
            "NOT IN (SELECT b.user.id FROM Blacklist b)")
    List<UserEntity> findAllUsersNotBlacklisted();

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.roles r WHERE r.role = 'MODERATOR'")
    Page<UserEntity> findAllModerators(Pageable pageable);

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    Optional<UserEntity> findByUsername(@Param("username") String username);

    void deleteByUsername(String username);
}
