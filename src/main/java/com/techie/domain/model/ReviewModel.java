package com.techie.domain.model;

import lombok.*;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewModel {
    private Long id;
    private UserDisplayView reviewer;
    private Long productId;
    private int productRating;
    private String comment;
    private List<String> imageUrls;
    private LocalDateTime date;
    private int upvote;
    private int downvote;
}
