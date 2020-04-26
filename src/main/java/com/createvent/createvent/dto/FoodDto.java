package com.createvent.createvent.dto;

import com.createvent.createvent.entity.Festival;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class FoodDto {
	
	private Long id;
	
	private String foodName;
	
	@JsonIgnore
	private String foodType;
	
	@JsonIgnore
	private byte[] logoUrl;
	
	@JsonIgnore
	private String facebook;
	
	@JsonIgnore
	private Festival festival;

	public FoodDto(Long id, String foodName) {
		this.id = id;
		this.foodName = foodName;

	}

}
