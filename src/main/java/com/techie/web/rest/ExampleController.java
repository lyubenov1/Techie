package com.techie.web.rest;

import org.springframework.web.bind.annotation.*;

/**
 * Example controller class demonstrating the usage of custom error page mapping.
 */
@RestController
@RequestMapping("/example")
public class ExampleController {

    /**
     * Handler method that deliberately throws a RuntimeException for demonstration purposes.
     *
     * @return This method does not return a value since it throws an exception.
     */
    @GetMapping("/test")
    public String testError() {
        throw new RuntimeException("Simulated internal server error");
    }
}