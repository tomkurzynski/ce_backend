package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Performer;

@CrossOrigin(origins = "*")
public interface PerformerRepository extends JpaRepository<Performer, Long>  {

}
