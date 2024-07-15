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
    private String firstName;
    private String lastName;
    private String profileImageUrl;
    private List<AddressDTO> addresses;
    private Set<WishlistDTO> wishlists;
}