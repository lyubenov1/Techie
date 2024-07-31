package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.exceptions.user.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Service
public class SettingsService {

    private final UserService userService;

    @Autowired
    public SettingsService(UserService userService) {
        this.userService = userService;
    }

    public boolean changeUserDetails(String email, String firstName, String lastName, String newUsername)
            throws UsernameNotFoundException, UsernameAlreadyTakenException {
        UserEntity user = userService.findByUsernameNoFetches(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        boolean isChanged = updateUserDetails(user, firstName, lastName, newUsername);

        if (isChanged) {
            userService.saveUser(user);
        }

        return isChanged;
    }

    private boolean updateUserDetails(UserEntity user, String firstName, String lastName, String newUsername)
                                        throws UsernameAlreadyTakenException {
        boolean isChanged = false;

        if (isNewUsernameValid(user, newUsername)) {
            user.setUsername(newUsername);
            isChanged = true;
        }

        if (isNonEmpty(firstName) && !firstName.equals(user.getFirstName())) {
            user.setFirstName(firstName);
            isChanged = true;
        }

        if (isNonEmpty(lastName) && !lastName.equals(user.getLastName())) {
            user.setLastName(lastName);
            isChanged = true;
        }

        return isChanged;
    }

    private boolean isNewUsernameValid(UserEntity user, String newUsername) throws UsernameAlreadyTakenException {
        if (isNonEmpty(newUsername) && !newUsername.equals(user.getUsername())) {
            if (userService.existsByUsername(newUsername)) {
                throw new UsernameAlreadyTakenException();
            }
            return true;
        }
        return false;
    }

    private boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
