package com.createvent.createvent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Performer;

@CrossOrigin(origins = "*")
public interface PerformerRepository extends JpaRepository<Performer, Long>  {
	
	List<Performer> getPerformerByFestivalId(Long id);
}
