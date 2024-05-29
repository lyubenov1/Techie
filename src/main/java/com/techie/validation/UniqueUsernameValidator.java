package com.techie.validation;

import com.techie.domain.model.UserRegisterFormDTO;
import com.techie.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, UserRegisterFormDTO> {

    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserRegisterFormDTO userRegisterFormDTO, ConstraintValidatorContext constraintValidatorContext) {
        String username = userRegisterFormDTO.getUsername();

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
