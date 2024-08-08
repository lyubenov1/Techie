package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o " +
            "LEFT JOIN FETCH o.deliveryAddress " +
            "LEFT JOIN FETCH o.orderItems " +
            "WHERE o.userEmail = :userEmail")
    Page<Order> findAllByUserEmail(@Param("userEmail") String userEmail, Pageable pageable);

    @Query("SELECT o FROM Order o " +
            "LEFT JOIN FETCH o.deliveryAddress " +
            "JOIN FETCH o.orderItems " +
            "WHERE o.id = :orderId")
    Optional<Order> findByOrderId(@Param("orderId") Long orderId);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.userEmail = :userEmail")
    long countByUserEmail(@Param("userEmail") String userEmail);
}
