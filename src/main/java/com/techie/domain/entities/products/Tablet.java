package com.techie.domain.entities.products;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tablets")
public class Tablet extends Product {

    @Column(nullable = false)
    private String screenSize;

    @Column(nullable = false)
    private String screenResolution;

    @Column(nullable = false)
    private int ram;

    @Column(nullable = false)
    private int storage;

    @Column(nullable = false)
    private int batteryCapacity;

    @Column(nullable = false)
    private int frontCamera;

    @Column(nullable = false)
    private int rearCamera;

    @Column(nullable = false)
    private int brightness;

    @Column(nullable = false)
    private int refreshRate;

    @Column(nullable = false)
    private int color;

    @Column(nullable = false)
    private int yearOfRelease;

}