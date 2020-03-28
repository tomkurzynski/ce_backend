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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Festival> festivals;
}
