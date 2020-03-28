package com.createvent.createvent.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "om.createvent.createvent")
public class DataRestConfig {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
