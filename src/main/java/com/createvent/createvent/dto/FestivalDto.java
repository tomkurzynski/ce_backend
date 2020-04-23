package com.createvent.createvent.dto;

import java.util.Date;

import com.createvent.createvent.entity.Food;
import com.createvent.createvent.entity.News;
import com.createvent.createvent.entity.Performer;
import com.createvent.createvent.entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class FestivalDto {

	private Long id;

	@JsonIgnore
	private Users user;

	private String name;

	private String eventDesc;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private Date dateFrom;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private Date dateTo;

	private byte[] logoUrl;

	private String facebook;

	private String twitter;

	private String location;

	private Food food;

	private News news;

	private Performer performers;

	public FestivalDto(Long id, Users users, String name, String eventDesc, Date dateFrom, Date dateTo, byte[] logoUrl,
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
