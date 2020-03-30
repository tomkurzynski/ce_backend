package com.createvent.createvent.dto;

import java.util.Date;
import java.util.List;

import com.createvent.createvent.entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodFestivalDto {

	private Long id;
	
	@JsonIgnore
	private Users user;
	
	@JsonIgnore
	private String name;
	
	@JsonIgnore
	private String eventDesc;
	
	@JsonIgnore
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private Date dateFrom;
	
	@JsonIgnore
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	
	private Date dateTo;
	@JsonIgnore
	private String logoUrl;
	
	@JsonIgnore
	private String facebook;
	
	@JsonIgnore
	private String twitter;

	@JsonIgnore
	private String location;
	
	@JsonIgnore
	private List<FoodDto> foodVendors;

	public FoodFestivalDto(Long id) {
		this.id = id;
	}

	public FoodFestivalDto(Long id, Users user, String name, String eventDesc, Date dateFrom, Date dateTo,
			String logoUrl, String facebook, String twitter, String location, List<FoodDto> foodVendors) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.eventDesc = eventDesc;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.logoUrl = logoUrl;
		this.facebook = facebook;
		this.twitter = twitter;
		this.location = location;
		this.foodVendors = foodVendors;
	}
	
	
}
