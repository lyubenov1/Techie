package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.exceptions.user.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
public class SubscriptionService {

    private final UserService userService;

    @Autowired
    public SubscriptionService(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void changeSubscriptionStatusSettings(String email, Boolean status)
                                              throws UsernameNotFoundException {
        UserEntity user = userService.findByUsernameNoFetches(email);

        if (status != null) {
            // Toggle subscription status for requests from the profile settings
            user.setSubscribed(status);
            userService.saveUser(user);
        }
    }

    @Transactional
    public void changeSubscriptionStatusFooter(String email)
            throws UsernameNotFoundException, UserIsAlreadySubscribedException {
        UserEntity user = userService.findByUsernameNoFetches(email);

        if (user.isSubscribed()) {
            throw new UserIsAlreadySubscribedException("User is already subscribed.");
        } else {
            user.setSubscribed(true);
            userService.saveUser(user);
        }
    }
}
