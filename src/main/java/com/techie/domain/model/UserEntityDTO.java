package com.techie.domain.model;

import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntityDTO {

    List<CommentDTO> comments;
}
