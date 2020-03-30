package com.createvent.createvent.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	
	//get by id
	@GetMapping("/foods/{id}")
	public FoodFoodDto getVendorById(@PathVariable Long id) {
		Optional<Food> foodVendor = foodService.getFoodVendorById(id);
		return convertToDto(foodVendor.get());
	}
	
	//add
	@PostMapping("/foods")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFoodVendor(@RequestBody Food foodVendor) {
		foodService.save(foodVendor);
	}
	
	//update
	@PutMapping("/foods/update/{id}")
	public void updateFoodVendor(@PathVariable Long id, @Valid @RequestBody Food foodVendor) {
		foodService.save(foodVendor);
	}
	
	//delete
	@DeleteMapping("/foods/delete/{id}")
	public void deleteFoodVendor(@PathVariable Long id) {
		foodService.delete(id);
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
