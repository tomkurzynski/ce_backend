package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.FoodRepository;
import com.createvent.createvent.dto.FoodFoodDto;
import com.createvent.createvent.entity.Food;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FoodService {
	
	private final FoodRepository foodRepository;
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	
	//list all
	public List<Food> getFoodVendorList() {
		return foodRepository.findAll();
	}
	
	//list by id
	public Optional<Food> getFoodVendorById(Long id) {
		return foodRepository.findById(id);
	}
	
	public List<Food> getFoodVendorByFestivalId(Long id) {
		return foodRepository.findByFestivalId(id);
	}
	
	//edit
//	public void save(Food food) {
//		foodRepository.save(food);
//	}
//	

	public void save(FoodFoodDto foodDto) {
		Food food = modelMapper.map(foodDto, Food.class);
		foodRepository.save(food);
	}
	
	
	//delete
	public void delete(Long id) {
		foodRepository.deleteById(id);
	}
}
