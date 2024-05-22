package com.techie.domain.entities.products;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "smartphones")
public class Smartphone extends Product {

    @Column(nullable = false)
    private String screenSize;

    @Column(nullable = false)
    private String screenResolution;

    @Column(nullable = false)
    private String ram;

    @Column(nullable = false)
    private String storage;

    @Column(nullable = false)
    private String batteryCapacity;

    @Column(nullable = false)
    private String frontCamera;

    @Column(nullable = false)
    private String rearCamera;

    @Column(nullable = false)
    private String refreshRate;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int yearOfRelease;

}