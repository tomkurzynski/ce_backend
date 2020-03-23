package com.createvent.createvent.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.EventRepository;

@Configuration
//@CrossOrigin(origins = "*")
public class DataRestConfig implements RepositoryRestConfigurer {

	private EntityManager entityManager;

	@Autowired
	public DataRestConfig(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		exposeIds(config);
	}

	private void exposeIds(RepositoryRestConfiguration config) {
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

		List<Class> entityClasses = new ArrayList<>();

		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}

		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);

	}

}
