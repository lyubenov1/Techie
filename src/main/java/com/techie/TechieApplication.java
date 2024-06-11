package com.techie;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.*;

@SpringBootApplication
@EnableCaching
public class TechieApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechieApplication.class, args);
	}

}
