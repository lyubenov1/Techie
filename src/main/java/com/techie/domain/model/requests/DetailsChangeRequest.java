package com.techie.domain.model.requests;

import lombok.*;

@Getter
@Setter
public class DetailsChangeRequest {  // The response body that is sent from the user's frontend for details change
    private String firstName;
    private String lastName;
    private String username;
}
