package com.techie.domain.model;

import lombok.*;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {

    private Long id;
    private String content;
    private LocalDateTime timestamp;
    private int upvoteCount;
    private int downvoteCount;
    private List<String> imageUrls;
    private int rating;
    private String user;

}