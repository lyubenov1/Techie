package com.techie.domain.entities.products.accessories;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chargers")
public class Charger extends Product {

    @Column(nullable = false)
    private String adapterType;

    @Column(nullable = false)
    private String wattage;
}