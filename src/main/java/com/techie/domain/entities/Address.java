package com.techie.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.*;

import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "name"}))   // Unique names of the addresses for a given user
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "address_line_1", nullable = false, length = 512)
    private String addressLine1;

    @Column(name = "address_line_2", length = 512)
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 75)
    private String city;

    @Column(name = "country", nullable = false, length = 75)
    private String country;

    @Column(name = "zipcode", nullable = false, length = 10)
    private String zipcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Address address = (Address) o;
        return getId() != null && Objects.equals(getId(), address.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}