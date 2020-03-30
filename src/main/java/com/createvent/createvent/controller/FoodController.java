package com.createvent.createvent.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dto.FestivalDto;
import com.createvent.createvent.dto.FoodDto;
import com.createvent.createvent.dto.FoodFestivalDto;
import com.createvent.createvent.dto.FoodFoodDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Food;
import com.createvent.createvent.service.FoodService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@GetMapping("/foods")
	public List<FoodFoodDto> getAllFoodVendors() {
		List<Food> foodVendors = foodService.getFoodVendorList();
		return foodVendors.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	private FoodFoodDto convertToDto(Food foodVendor) {
		return new FoodFoodDto(foodVendor.getId(),
				foodVendor.getFoodName(),
				foodVendor.getFoodType(),
				foodVendor.getLogoUrl(),
				foodVendor.getFacebook(),
				convertToDto(foodVendor.getFestival()));
	}

	private FoodFestivalDto convertToDto(Festival festival) {
		return new FoodFestivalDto(festival.getId());
	}
}
