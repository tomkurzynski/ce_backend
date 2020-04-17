package com.createvent.createvent.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.createvent.createvent")
@CrossOrigin(origins = "*")
public class DataRestConfig {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
