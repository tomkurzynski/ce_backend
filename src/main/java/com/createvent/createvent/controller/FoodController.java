package com.createvent.createvent.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
//	@PostMapping(value = "/foods", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	@ResponseStatus(HttpStatus.CREATED)
//	public void addFoodVendor(@RequestBody Food foodVendor, MultipartFile file) {
//		foodService.save(foodVendor);
//	}

	@PostMapping(value = "/foods", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String upload(@RequestParam("file") MultipartFile file,
						 @RequestParam("food") Food food) {
		return food + "\n" + file.getOriginalFilename() + "\n" + file.getSize();
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
