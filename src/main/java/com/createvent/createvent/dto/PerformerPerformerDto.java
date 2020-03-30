package com.createvent.createvent.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PerformerPerformerDto {

	private Long id;
	
	private String name;
	
	private String description;
	
	private String webUrl;
	
	private String youtube;

	private String facebook;

	private String twitter;

	private String spotify;
	
	@JsonIgnore
	private PerformerFestivalDto festival;
	
}
