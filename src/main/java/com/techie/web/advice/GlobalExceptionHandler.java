package com.techie.web.advice;

import com.techie.exceptions.*;
import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ObjectNotFoundException.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public String onProductNotFound(ObjectNotFoundException ex) {
        logger.info("ObjectNotFoundException: {}", ex.getMessage(), ex);
        return "/error-pages/not-found";
    }

    // Catch-all for other exceptions
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralException(Exception ex) {
        logger.error("Unexpected error occurred: ", ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error-pages/error");
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return modelAndView;
    }
}
