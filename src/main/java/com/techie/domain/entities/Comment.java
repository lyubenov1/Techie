package com.techie.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(columnDefinition = "TEXT", nullable = false, length = 600)   // TODO: implement character count
    private String content;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "upvote_count")
    private int upvote;

    @Column(name = "downvote_count")
    private int downvote;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CommentImage> images;

    public void addImage(CommentImage image) {
        images.add(image);
        image.setComment(this);
    }

    public void removeImage(CommentImage image) {
        images.remove(image);
        image.setComment(null);
    }

}
