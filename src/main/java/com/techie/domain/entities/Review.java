package com.techie.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "reviews", indexes = {
        @Index(name = "idx_reviews_product_id", columnList = "product_id")
})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private int productRating;

    @Column(columnDefinition = "TEXT")
    @Size(max = 600, message = "Comment cannot exceed 600 characters")
    private String comment;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "upvote_count")
    @ColumnDefault("0")
    private int upvote;

    @Column(name = "downvote_count")
    @ColumnDefault("0")
    private int downvote;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Size(max = 3, message = "A review cannot have more than 3 images")
    private List<ReviewImage> images;

}