package com.createvent.createvent.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.createvent.createvent.entity.Food;
import com.createvent.createvent.entity.News;
import com.createvent.createvent.entity.Performer;
import com.createvent.createvent.entity.Users;

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
