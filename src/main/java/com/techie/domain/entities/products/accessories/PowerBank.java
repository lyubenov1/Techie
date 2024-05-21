package com.techie.domain.entities.products.accessories;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "power_banks")
public class PowerBank extends Product {

    @Column(nullable = false)
    private int batteryCapacity;

    @Column(nullable = false)
    private int color;

}