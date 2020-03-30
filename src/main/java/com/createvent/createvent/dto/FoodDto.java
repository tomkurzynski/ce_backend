package com.createvent.createvent.dto;

import com.createvent.createvent.entity.Festival;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
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

//	public FoodDto(Long id, String foodName, String foodType, byte[] logoUrl, String facebook, Festival festival) {
//		this.id = id;
//		this.foodName = foodName;
//		this.foodType = foodType;
//		this.logoUrl = logoUrl;
//		this.facebook = facebook;
//		this.festival = festival;
//	}

	public FoodDto(Long id, String foodName) {
		this.id = id;
		this.foodName = foodName;

	}

}
