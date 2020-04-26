package com.createvent.createvent.dto;

import java.util.Date;
import java.util.List;

import com.createvent.createvent.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class StageRoomFestivalDto {

	private Long id;
	
	@JsonIgnore
	private Users user;
	
	@JsonIgnore
	private String name;
	
	@JsonIgnore
	private String eventDesc;
	
	@JsonIgnore
	private Date dateFrom;
	
	@JsonIgnore
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
	private List<FoodDto> food;
	
	@JsonIgnore
	List<NewsDto> news;
	
	@JsonIgnore
	private List<PerformerDto> performers;
	
	@JsonIgnore List<StageRoomDto> stageRooms;

	public StageRoomFestivalDto(Long id) {
		this.id = id;
	}

	public StageRoomFestivalDto() {
	}
	
	
}
