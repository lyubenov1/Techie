package com.techie.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBlacklistView {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String profileImage;
    private String timestamp;
    private String reason;
}