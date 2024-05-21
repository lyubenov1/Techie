package com.techie.domain.entities.products.accessories;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "earbuds")
public class Earbuds extends Product {

    @Column(nullable = false)
    private String connectionType;

    @Column
    private String batteryLife;

    @Column
    private String batteryLifeWithCase;

    @Column(nullable = false)
    private boolean anc = false;

    @Column
    private int bluetoothVersion;

    @Column(nullable = false)
    private int fit;

    @Column(nullable = false)
    private int color;

    @Column(nullable = false)
    private int yearOfRelease;

}