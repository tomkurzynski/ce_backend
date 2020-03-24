package com.createvent.createvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dao.FoodRepository;
import com.createvent.createvent.entity.Food;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "foods")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;
    
    @GetMapping()
	public List<Food> getFoods() {
		return (List<Food>) foodRepository.findAll();
	}
	
	@PostMapping()
	void addFood(@RequestBody Food food) {
		
		System.out.println(food.getEvent().getId());
		foodRepository.save(food);
	}

   
}

