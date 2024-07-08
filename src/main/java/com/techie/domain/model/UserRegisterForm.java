package com.techie.domain.model;

import com.techie.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatch(password = "password", confirmPassword = "confirmPassword")
@UniqueUsername
@UniqueEmail
public class UserRegisterForm {

    @NotBlank(message = "Username is required.")
    @Size(min = 4, max = 25, message = "Username size must be between 4 and 25 characters.")
    private String username;

    @NotBlank(message = "Email is required.")
    @Email
    private String email;

    @NotBlank(message = "Password is required.")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long and contain at least one digit," +
                    " one lowercase letter, one uppercase letter, and one special character."
    )
    private String password;

    @NotBlank(message = "Confirm password is required.")
    private String confirmPassword;

    @NotBlank(message = "First name is required.")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(max = 50)
    private String lastName;

    @NotBlank(message = "Address line 1 is required.")
    @Size(max = 50)
    private String addressLine1;

    @Size(max = 50)
    private String addressLine2;

    @NotBlank(message = "City is required.")
    @Size(max = 50)
    private String city;

    @NotBlank(message = "Country is required.")
    @Size(max = 50)
    private String country;

    @NotBlank(message = "Zip code is required.")
    @Size(max = 20)
    private String zipCode;
}