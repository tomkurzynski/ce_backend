package com.createvent.createvent.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dto.FestivalDto;
import com.createvent.createvent.dto.UserDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Users;
import com.createvent.createvent.service.UserService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/users")
	public List<UserDto> getAllUsers() {
		List<Users> users = userService.getAllUsers();
		
		return users.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	private UserDto convertToDto(Users user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getFestival());
	}
}
