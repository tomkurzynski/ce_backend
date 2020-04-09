package com.createvent.createvent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Festival;

@CrossOrigin(origins = "*")
//@RepositoryRestResource
public interface FestivalRepository extends JpaRepository<Festival, Long>{
	
	List<Festival> findByUserId(Long id);

}
