package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.exceptions.subscription.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
public class SubscriptionService {

    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public SubscriptionService(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
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
    public void subscribeFromFooter(String email)
            throws UsernameNotFoundException, UserIsAlreadySubscribedException {
        UserEntity user = userService.findByUsernameNoFetches(email);

        if (user.isSubscribed()) {
            throw new UserIsAlreadySubscribedException("User is already subscribed.");
        } else {
            user.setSubscribed(true);
            userService.saveUser(user);
        }
    }

    @Transactional
    public void unsubscribe(String token) throws UsernameNotFoundException, IllegalArgumentException {
        String userEmail = tokenService.getEmailByToken(token);

        if (userEmail == null) {
            throw new IllegalArgumentException("Invalid or expired token");
        }

        UserEntity user = userService.findByUsernameNoFetches(userEmail);
        user.setSubscribed(false);

        tokenService.removeToken(token);
        userService.saveUser(user);
    }
}
