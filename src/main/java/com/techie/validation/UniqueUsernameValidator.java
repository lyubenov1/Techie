package com.techie.validation;

import com.techie.domain.model.*;
import com.techie.repository.*;
import jakarta.validation.*;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, RegisterModel> {

    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(RegisterModel registerModel, ConstraintValidatorContext constraintValidatorContext) {
        String username = registerModel.getUsername();

        // Check if username is already taken
        if (userRepository.existsByUsername(username)) {
            addConstraintViolation(constraintValidatorContext, "username");
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
