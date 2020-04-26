package com.createvent.createvent.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String email;
	
	private List<FestivalDto> festivals;

	public UserDto(Long id, String firstName, String lastName, String password, String email, List<FestivalDto> festivals) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.festivals = festivals;
		
	}

	public UserDto() {
	}
	
	
	
}
