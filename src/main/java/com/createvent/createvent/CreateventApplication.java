package com.createvent.createvent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin(origins = "*")
public class CreateventApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateventApplication.class, args);
	}

}
