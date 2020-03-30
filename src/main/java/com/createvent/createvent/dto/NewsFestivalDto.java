package com.createvent.createvent.dto;

import java.util.Date;
import java.util.List;

import com.createvent.createvent.entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data
public class NewsFestivalDto {

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
	private List<NewsDto> news;
	
	public NewsFestivalDto(Long id) {
		this.id = id;
	}

//	public FestivalDto(Long id, Users users, String name, String eventDesc, Date dateFrom, Date dateTo, String logoUrl,
//			String facebook, String twitter, String location) {
//		this.id = id;
//		this.user = users;
//		this.name = name;
//		this.eventDesc = eventDesc;
//		this.dateFrom = dateFrom;
//		this.dateTo = dateTo;
//		this.logoUrl = logoUrl;
//		this.facebook = facebook;
//		this.twitter = twitter;
//		this.location = location;
//	}
//
//	public FestivalDto(Long id) {
//		this.id = id;
//	}
//	
	
}
