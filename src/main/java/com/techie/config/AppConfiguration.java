package com.techie.config;

import org.modelmapper.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
