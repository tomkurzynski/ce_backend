package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createvent.createvent.entity.Performer;

public interface PerformerRepository extends JpaRepository<Performer, Long>  {

}
