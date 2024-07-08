package com.techie.validation;

import jakarta.validation.*;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {UniqueEmailValidator.class})
public @interface UniqueEmail {
    String message() default "Email is already taken!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
