package com.createvent.createvent.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.createvent.createvent.entity.Festival;

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
	
	private Set<Festival> festivals;

	public UserDto(Long id, String firstName, String lastName, String password, String email, Set<Festival> festivals) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.festivals = festivals;
	}
	
	
}
