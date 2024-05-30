package com.techie.domain.model;

import com.techie.validation.PasswordMatch;
import com.techie.validation.UniqueEmail;
import com.techie.validation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatch(password = "password", confirmPassword = "confirmPassword")
@UniqueUsername
@UniqueEmail
public class UserRegisterFormDTO {

    @NotBlank(message = "Username is required.")
    @Size(min = 4, max = 25)
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

}