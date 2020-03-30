package com.createvent.createvent.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.FoodRepository;
import com.createvent.createvent.entity.Food;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FoodService {
	
	private final FoodRepository foodRepository;
	
	//list all
	public List<Food> getFoodVendorList() {
		return foodRepository.findAll();
	}
	//list by id
	
	//edit
	
	//delete

}
