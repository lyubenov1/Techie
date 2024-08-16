package com.techie.domain.model.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDisplayView {
    private Long id;
    private String username;
    private String email;
    private String role;  // Highest role of a user
    private String firstName;
    private String lastName;
    private String profileImage;
    private String createdAt;  // date and time the user created his profile
    private String reason;  // reasoning of potential blacklisting
    private String blacklistTimestamp;
    private boolean isSubscribed;  // subscription status to newsletter

    public UserDisplayView(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

}