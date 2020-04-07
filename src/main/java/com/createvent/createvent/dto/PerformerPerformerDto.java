package com.createvent.createvent.dto;

import lombok.Data;

@Data
public class PerformerPerformerDto {

	private Long id;
	
	private String name;
	
	private String description;
	
	private String webUrl;
	
	private String facebook;

	private String twitter;

	private String youtube;

	private String spotify;
	
	private PerformerFestivalDto festival;
	
	private byte[] photo;
//	{"name":"321","description":"123","webUrl":"123","facebook":"123","twitter":"123","youtube":"123","spotify":"123","festival":{"id":"1"},"photo":null}
	

	public PerformerPerformerDto(Long id, String name, String description, String webUrl, String facebook,
			String twitter, String youtube, String spotify, PerformerFestivalDto festival, byte[] photo) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.webUrl = webUrl;
		this.facebook = facebook;
		this.youtube = youtube;
		this.twitter = twitter;
		this.spotify = spotify;
		this.festival = festival;
		this.photo = photo;
	}
	
}
