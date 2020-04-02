package com.createvent.createvent.dto;

import java.sql.Blob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodFoodDto {
	private Long id;
	
	private String foodName;
	
	private String foodType;
	
	private Blob logoUrl;
	
	private String facebook;
	
	private FoodFestivalDto festival;

	public FoodFoodDto(Long id, String foodName, String foodType, Blob logoUrl, String facebook, FoodFestivalDto festival) {
		this.id = id;
		this.foodName = foodName;
		this.foodType = foodType;
		this.logoUrl = logoUrl;
		this.facebook = facebook;
		this.festival = festival;
	}

}
