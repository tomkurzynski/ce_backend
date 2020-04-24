package com.createvent.createvent.dto;

import java.util.Date;

import com.createvent.createvent.entity.Festival;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class NewsDto {

	private Long id;
	
	private String title;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date dateCreated;
	
	@JsonIgnore
	private Date lastUpdated;
	
	@JsonIgnore
	private String newsBody;
	
	@JsonIgnore
	private Festival festival;
	
	public NewsDto(Long id, String title, Date dateCreated) {
		this.id = id;
		this.title = title;
		this.dateCreated = dateCreated;
	}
	
	
}
