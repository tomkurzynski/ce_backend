package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Festival;

@CrossOrigin(origins = "*")
//@RepositoryRestResource
public interface FestivalRepository extends CrudRepository<Festival, Long>{

}
