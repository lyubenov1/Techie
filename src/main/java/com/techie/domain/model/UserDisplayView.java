package com.techie.domain.model;

import com.techie.domain.model.DTOs.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDisplayView {
    private Long id;
    private String username;
    private String email;
    private String role;
    private String firstName;
    private String lastName;
    private String profileImage;
    private String createdAt;  // date and time the user created his profile
    private List<WishlistDTO> wishlists;
    private String reason;  // reasoning of potential blacklisting
}