package com.techie;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.*;
import org.springframework.scheduling.annotation.*;

@SpringBootApplication
@EnableCaching
@EnableAsync
public class TechieApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechieApplication.class, args);
	}

}
