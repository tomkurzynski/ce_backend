package com.createvent.createvent.dto;

import java.util.Date;

import com.createvent.createvent.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FestivalDto {

	private Long id;
	
//	@JsonManagedReference
	@JsonIgnore
	private Users user;
	
	private String name;
	
	private String eventDesc;
	
	private Date dateFrom;
	

	private Date dateTo;
	
	private String logoUrl;
	
	private String facebook;
	
	private String twitter;

	private String location;

	public FestivalDto(Long id, Users users, String name, String eventDesc, Date dateFrom, Date dateTo, String logoUrl,
			String facebook, String twitter, String location) {
		this.id = id;
		this.user = users;
		this.name = name;
		this.eventDesc = eventDesc;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.logoUrl = logoUrl;
		this.facebook = facebook;
		this.twitter = twitter;
		this.location = location;
	}
	
	
}
