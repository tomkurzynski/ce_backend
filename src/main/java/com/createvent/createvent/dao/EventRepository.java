package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Event;

@CrossOrigin(origins = "*")
//@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event, Long>{

}
