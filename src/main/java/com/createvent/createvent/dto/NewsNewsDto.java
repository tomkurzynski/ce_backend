package com.createvent.createvent.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class NewsNewsDto {

	private Long id;
	
	private String title;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private Date dateCreated;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private Date lastUpdated;
	
	private String newsBody;
	
	@JsonIgnore
	private NewsFestivalDto festival;
	
	public NewsNewsDto(Long id, String title, String newsBody, Date dateCreated, Date lastUpdated,
			NewsFestivalDto festival) {
		this.id = id;
		this.title = title;
		this.newsBody = newsBody;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}	
}
