package com.techie.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "review_images")
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "public_id", nullable = false)
    private String publicId;  // Cloudinary public ID for a given asset (photo)
}