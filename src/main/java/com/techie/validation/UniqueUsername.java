package com.techie.validation;

import jakarta.validation.*;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {
    String message() default "Username is already taken!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
