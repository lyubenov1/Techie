package com.techie.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "comment_images")
public class CommentImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(name = "image_id", nullable = false)
    private String imageId;   // Cloudinary public ID for the image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentImage)) return false;
        return id != null &&
                id.equals(((CommentImage) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}