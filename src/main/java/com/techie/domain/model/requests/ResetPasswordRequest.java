package com.techie.domain.model.requests;

import com.techie.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatch(password = "password", confirmPassword = "confirmPassword")
public class ResetPasswordRequest {

    @NotBlank(message = "Password is required.")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long and contain at least one digit," +
                    " one lowercase letter, one uppercase letter, and one special character."
    )
    private String password;

    @NotBlank(message = "Confirm password is required.")
    private String confirmPassword;

    @NotBlank
    private String token;
}
