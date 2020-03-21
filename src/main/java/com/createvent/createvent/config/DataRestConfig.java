package com.createvent.createvent.config;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
	
	private EntityManager entityManager;

	@Autowired
	public DataRestConfig(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	

}
