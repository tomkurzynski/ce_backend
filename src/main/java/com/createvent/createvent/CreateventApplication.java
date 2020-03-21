package com.createvent.createvent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class CreateventApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateventApplication.class, args);
	}

}
