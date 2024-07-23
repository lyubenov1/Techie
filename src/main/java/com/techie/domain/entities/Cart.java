package com.techie.domain.entities;

import com.techie.events.listeners.*;
import jakarta.persistence.*;
import lombok.*;

import java.math.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cart")
@EntityListeners(CartListener.class) // TODO: implement 'save abandoned carts' logic
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private UserEntity user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;  // Timestamp of last cart update

    @Column(name = "grand_total", precision = 10, scale = 2)
    private BigDecimal grandTotal;

    public void addItem(CartItem item) {
        cartItems.add(item);
        item.setCart(this);
    }

    public void removeItem(CartItem item) {
        cartItems.remove(item);
        item.setCart(null);
    }

}
