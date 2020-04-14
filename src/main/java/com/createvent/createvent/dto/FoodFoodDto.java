package com.createvent.createvent.dto;

import lombok.Data;

@Data
public class FoodFoodDto {
	private Long id;
	
	private String foodName;
	
	private String foodType;
	
	private byte[] logoUrl;
	
	private String facebook;
	
	private FoodFestivalDto festival;

	public FoodFoodDto(Long id, String foodName, String foodType, byte[] logoUrl, String facebook, FoodFestivalDto festival) {
		this.id = id;
		this.foodName = foodName;
		this.foodType = foodType;
		this.logoUrl = logoUrl;
		this.facebook = facebook;
		this.festival = festival;
	}

}
