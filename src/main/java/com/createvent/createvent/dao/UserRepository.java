package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Users;

//@RepositoryRestResource(collectionResourceRel = "user", path = "users")
@CrossOrigin(origins = "*")
public interface UserRepository extends CrudRepository<Users, Long>{

}
