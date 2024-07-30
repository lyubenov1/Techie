package com.techie.domain.model;

import lombok.*;

@Getter
@Setter
public class UserDetailsChangeModel {  // The response body that is sent from the user's frontend for details change
    private String firstName;
    private String lastName;
    private String username;
}
