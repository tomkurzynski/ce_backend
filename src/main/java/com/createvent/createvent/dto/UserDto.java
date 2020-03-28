package com.createvent.createvent.dto;

import java.util.List;

import com.createvent.createvent.entity.Festival;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	private List<Festival> festivals;

	public UserDto(Long id, String firstName, String lastName, String password, String email, List<Festival> festivals) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.festivals = festivals;
	}
	
	
}
