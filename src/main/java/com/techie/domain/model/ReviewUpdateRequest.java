package com.techie.domain.model;

import lombok.*;

import java.util.*;

@Getter
@Setter
public class ReviewUpdateRequest {
    private String comment;
    private Integer rating;
    private List<String> remainingImageUrls;
}