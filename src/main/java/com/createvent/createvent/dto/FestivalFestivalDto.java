package com.createvent.createvent.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FestivalFestivalDto {

	private Long id;

	private FestivalUserDto user;

	private String name;

	private String eventDesc;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date dateFrom;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date dateTo;

	private byte[] logoUrl;

	private String facebook;

	private String twitter;

	private String location;

	private List<FoodDto> foodVendors;

	private List<NewsDto> news;

	public FestivalFestivalDto(Long id, FestivalUserDto users, String name, String eventDesc, Date dateFrom,
			Date dateTo, byte[] logoUrl, String facebook, String twitter, String location, List<FoodDto> foodVendors,
			List<NewsDto> news) {
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
		this.foodVendors = foodVendors;
		this.news = news;
	}

}
