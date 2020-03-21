package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.createvent.createvent.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
