package com.techie.web.advice;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.service.*;
import com.techie.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalControllerAdvice {

    private final UserService userService;

    @Autowired
    public GlobalControllerAdvice(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addUserToModel(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails != null) {
            UserEntity user = userService.findByUsername(userDetails.getUsername());
            UserDisplayView userDisplayView = UserConversionUtils.convertToView(user);

            model.addAttribute("loggedUser", userDisplayView);
        }
    }
}