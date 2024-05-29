package com.techie.domain.model;

import com.techie.validation.PasswordMatch;
import com.techie.validation.UniqueEmail;
import com.techie.validation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    @Size(min = 4, max = 25)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 20)
    private String password;

    @NotNull
    @Size(min = 5, max = 20)
    private String confirmPassword;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

}