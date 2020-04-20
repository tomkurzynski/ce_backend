	package com.createvent.createvent.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.createvent.createvent.dto.FoodDto;
import com.createvent.createvent.dto.FoodFestivalDto;
import com.createvent.createvent.dto.FoodFoodDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Food;
import com.createvent.createvent.service.FoodService;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = "*")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private StringToFoodDtoConverter foodConverter;
		
	@GetMapping()
	public List<FoodFoodDto> getAllFoodVendors() {
		List<Food> foodVendors = foodService.getFoodVendorList();
		return foodVendors.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//get by id
	@GetMapping("/{id}")
	public FoodFoodDto getVendorById(@PathVariable Long id) {
		Optional<Food> foodVendor = foodService.getFoodVendorById(id);
		return convertToDto(foodVendor.get());
	}
	
	@GetMapping("/festival/{id}")
	public List<FoodFoodDto> getVendorsByFestivalId(@PathVariable Long id) {
		List<Food> foodVendors = foodService.getFoodVendorByFestivalId(id);
		return foodVendors.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	


//	@PostMapping(value = "/foods", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	@ResponseStatus(HttpStatus.CREATED)
//	public void addFoodVendor(@RequestBody FoodFoodDto foodVendor, MultipartFile file) {
//		foodService.save(foodVendor);
//	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public FoodFoodDto upload(@RequestPart(name = "file", required = false) MultipartFile file,
						 @RequestPart("food") String food) throws IOException {
//		return food + "\n" + file.getOriginalFilename() + "\n" + file.getSize();
		FoodFoodDto foodConverted = foodConverter.convert(food); 
		if(file != null) {
			foodConverted.setLogoUrl(file.getBytes());
		}
		
		foodService.save(foodConverted);
		return foodConverted;
	
	}
	
	//update
	@PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateFoodVendor(@PathVariable Long id, @Valid @RequestPart(name = "file", required = false) MultipartFile file,
								@RequestPart("food") String food) throws IOException {
		FoodFoodDto foodConverted = foodConverter.convert(food);
		if(file != null) {
			foodConverted.setLogoUrl(file.getBytes());
		}
		foodService.save(foodConverted);
	}
	
	//delete
	@DeleteMapping("/{id}")
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
