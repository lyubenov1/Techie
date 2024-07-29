package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a WHERE a.user.email = :email")
    List<Address> findByUserEmail(@Param("email") String email);

    @Query("SELECT EXISTS (SELECT 1 FROM Address a WHERE a.name = :name AND a.user.username = :username)")
    boolean existsByNameAndUserUsername(@Param("name") String name, @Param("username") String username);

    @Query("SELECT a FROM Address a WHERE a.id = :id AND a.user.username = :username")
    Address findByIdAndUserUsername(@Param("id") Long id, @Param("username") String username);

    @Query("SELECT a FROM Address a WHERE a.name = :addressName AND a.user.username = :username")
    Address findByNameAndUserUsername(@Param("addressName") String addressName, @Param("username") String username);
}
