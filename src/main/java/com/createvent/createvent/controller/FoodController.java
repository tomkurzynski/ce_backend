package com.createvent.createvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dao.EventRepository;
import com.createvent.createvent.dao.FoodRepository;
import com.createvent.createvent.entity.Food;


@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/foods")
@RestController
public class FoodController {

    @Autowired
    FoodRepository foodRepository;
    
    @Autowired
    EventRepository eventRepository;
    
    @GetMapping()
	public List<Food> getFoods() {
		return (List<Food>) foodRepository.findAll();
	}
	
	@PostMapping()
	void addFood(@RequestBody Food food) {
		
	//	System.out.println(food.getEvent().getId());
		//food.set
		food.setEvent(eventRepository.findById(food.getEvent().getId()).get());
		foodRepository.save(food);
		
	}

   
}

