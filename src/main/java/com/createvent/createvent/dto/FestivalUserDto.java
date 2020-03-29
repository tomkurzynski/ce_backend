package com.createvent.createvent.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FestivalUserDto {
	private Long id;
	
	@JsonIgnore
	private String firstName;
	
	@JsonIgnore
	private String lastName;
	
	@JsonIgnore
	private String password;
	
	@JsonIgnore
	private String email;
	
	@JsonIgnore
	private List<FestivalDto> festivals;

	public FestivalUserDto(Long id, String firstName, String lastName, String password, String email, List<FestivalDto> festivals) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.festivals = festivals;
		
	}

	public FestivalUserDto(Long id) {
		this.id = id;
	}
	
	
	
}
