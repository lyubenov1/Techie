package com.techie.validation;

import com.techie.domain.model.UserRegisterFormDTO;
import com.techie.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserRegisterFormDTO> {

    private final UserRepository userRepository;

    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserRegisterFormDTO userRegisterFormDTO, ConstraintValidatorContext constraintValidatorContext) {
        String email = userRegisterFormDTO.getEmail();

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
