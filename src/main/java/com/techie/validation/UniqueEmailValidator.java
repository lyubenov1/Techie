package com.techie.validation;

import com.techie.domain.model.*;
import com.techie.repository.*;
import jakarta.validation.*;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserRegisterForm> {

    private final UserRepository userRepository;

    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserRegisterForm userRegisterForm, ConstraintValidatorContext constraintValidatorContext) {
        String email = userRegisterForm.getEmail();

        // Check if email is already taken
        if (userRepository.existsByEmail(email)) {
            addConstraintViolation(constraintValidatorContext, "email");
            return false;
        }

        return true;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String field) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}
