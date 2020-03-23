package com.createvent.createvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dao.EventRepository;
import com.createvent.createvent.entity.Event;

@RestController
@CrossOrigin(origins = "*")
public class EventController {
	
	@Autowired
	EventRepository eventRepository;
	
	@GetMapping("/events")
	public List<Event> getEvents() {
		return (List<Event>) eventRepository.findAll();
	}
	
	@PostMapping("/events")
	void addEvent(@RequestBody Event event) {
		eventRepository.save(event);
	}

}
