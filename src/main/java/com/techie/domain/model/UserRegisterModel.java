package com.techie.domain.model;

import com.techie.validation.PasswordMatch;
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
public class UserRegisterModel {

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
    private String firstName;

    @NotNull
    private String lastName;

}