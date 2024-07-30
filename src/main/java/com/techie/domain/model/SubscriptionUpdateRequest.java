package com.techie.domain.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class SubscriptionUpdateRequest {
    @Email(message = "Invalid email address")
    private String email;
    private Boolean status;
}
