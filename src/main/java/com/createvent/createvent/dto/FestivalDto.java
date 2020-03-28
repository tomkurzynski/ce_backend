package com.createvent.createvent.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FestivalDto {

	private Long id;
	
	private UserDto user;
	
	private String name;
	
	private String eventDesc;
	
	private Date dateFrom;
	

	private Date dateTo;
	
	private String logoUrl;
	
	private String facebook;
	
	private String twitter;

	private String location;
}
