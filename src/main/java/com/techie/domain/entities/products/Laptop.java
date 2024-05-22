package com.techie.domain.entities.products;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "laptops")
public class Laptop extends Product {

    @Column(nullable = false)
    private String screenSize;

    @Column(nullable = false)
    private String screenResolution;

    @Column(nullable = false)
    private String processor;

    @Column(nullable = false)
    private String gpu;

    @Column(nullable = false)
    private String ram;

    @Column(nullable = false)
    private String storageType;

    @Column(nullable = false)
    private String storage;

    @Column(nullable = false)
    private String operatingSystem;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int yearOfRelease;
}