package com.techie.domain.entities;

import com.techie.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.math.*;
import java.time.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders", indexes = {
        @Index(name = "idx_user_email", columnList = "userEmail")
})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    @Column
    private String anonymousAddress;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_item_id")
    )
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "grand_total", precision = 10, scale = 2)
    private BigDecimal grandTotal = BigDecimal.ZERO;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
