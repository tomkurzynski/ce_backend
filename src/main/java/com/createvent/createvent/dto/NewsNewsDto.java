package com.createvent.createvent.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class NewsNewsDto {

	public NewsNewsDto(Long id, String title, String newsBody, Date dateCreated, Date lastUpdated,
			NewsFestivalDto festival) {
		this.id = id;
		this.title = title;
		this.newsBody = newsBody;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}

private Long id;
	
	private String title;
	
	private Date dateCreated;
	
	private Date lastUpdated;
	
	private String newsBody;
	
	@JsonIgnore
	private NewsFestivalDto festival;
	
	
}
