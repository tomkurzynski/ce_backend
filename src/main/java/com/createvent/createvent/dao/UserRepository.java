package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Users;

@CrossOrigin(origins = "*")
public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByEmail(String email);

}
