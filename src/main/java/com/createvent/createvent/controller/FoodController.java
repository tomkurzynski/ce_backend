package com.createvent.createvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dao.FoodRepository;
import com.createvent.createvent.entity.Food;

@RestController
@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;
    
    @GetMapping("/foods")
	public List<Food> getFoods() {
		return (List<Food>) foodRepository.findAll();
	}
	
	@PostMapping("/foods")
	void addFood(@RequestBody Food food) {
		foodRepository.save(food);
	}

   
}

