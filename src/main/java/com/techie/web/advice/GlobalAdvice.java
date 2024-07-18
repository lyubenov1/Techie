package com.techie.web.advice;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@ControllerAdvice
public class GlobalAdvice {
    private static final Logger logger = LoggerFactory.getLogger(GlobalAdvice.class);

    private final UserService userService;

    @Autowired
    public GlobalAdvice(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addUserToModel(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails != null) {
            UserEntity user = userService.findByUsername(userDetails.getUsername());
            UserDisplayView userDisplayView = userService.convertToView(user);
            model.addAttribute("loggedUser", userDisplayView);
        }
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView onProductNotFound(ObjectNotFoundException ex, @AuthenticationPrincipal UserDetails userDetails) {
        logger.info("ObjectNotFoundException: {}", ex.getMessage(), ex);
        ModelAndView modelAndView = new ModelAndView("error-pages/not-found");
        addUserToModel(userDetails, modelAndView.getModel());
        return modelAndView;
    }

    // Catch-all for other exceptions
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralException(Exception ex, @AuthenticationPrincipal UserDetails userDetails) {
        logger.error("Unexpected error occurred: ", ex);
        ModelAndView modelAndView = new ModelAndView("error-pages/error");
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        addUserToModel(userDetails, modelAndView.getModel());
        return modelAndView;
    }

    private void addUserToModel(UserDetails userDetails, Map<String, Object> model) {
        if (userDetails != null) {
            UserEntity user = userService.findByUsername(userDetails.getUsername());
            UserDisplayView userDisplayView = userService.convertToView(user);
            model.put("loggedUser", userDisplayView);
        }
    }
}

