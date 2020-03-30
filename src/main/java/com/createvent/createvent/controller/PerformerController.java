package com.createvent.createvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.service.PerformerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PerformerController {

	@Autowired
	private PerformerService performerService;
	
	//get all
	
	//get by id
	
	//add
	
	//update
	
	//delete
}
