package com.createvent.createvent.dto;

import com.createvent.createvent.entity.Festival;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PerformerDto {
	
	private Long id;
	
	private String name;
	
	@JsonIgnore
	private String description;
	
	@JsonIgnore
	private String webUrl;
	
	@JsonIgnore
	private String youtube;
	
	@JsonIgnore
	private String facebook;
	
	@JsonIgnore
	private String twitter;
	
	@JsonIgnore
	private String spotify;
	
	@JsonIgnore
	private Festival festival;

	public PerformerDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	

}
