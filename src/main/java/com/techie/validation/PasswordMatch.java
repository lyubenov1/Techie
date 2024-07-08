package com.techie.validation;

import jakarta.validation.*;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordMatcher.class)
public @interface PasswordMatch {

    String password();

    String confirmPassword();

    String message() default "Passwords miss match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
