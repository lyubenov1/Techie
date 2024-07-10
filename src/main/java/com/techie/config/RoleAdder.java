package com.techie.config;

import com.techie.domain.enums.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class RoleAdder implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public RoleAdder(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        // Add ADMIN role to a user with the given email
        String email = "user@example.com"; // Replace with the actual email
        userService.addRoleToUser(email, UserRoleEnum.ADMIN);
    }
}