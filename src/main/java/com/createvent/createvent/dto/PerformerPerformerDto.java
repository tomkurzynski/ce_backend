package com.createvent.createvent.dto;

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
	
	
	private PerformerFestivalDto festival;
	
	public PerformerPerformerDto(Long id, String name, String description, String webUrl, String facebook,
			String youtube, String twitter, String spotify, PerformerFestivalDto festival) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.webUrl = webUrl;
		this.facebook = facebook;
		this.youtube = youtube;
		this.twitter = twitter;
		this.spotify = spotify;
		this.festival = festival;
	}
	
}
