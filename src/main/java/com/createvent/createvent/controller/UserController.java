package com.createvent.createvent.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dto.FestivalDto;
import com.createvent.createvent.dto.UserDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Users;
import com.createvent.createvent.service.FestivalService;
import com.createvent.createvent.service.UserService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FestivalService festivalService;
	
		
	@GetMapping(value = "/users")
	public List<UserDto> getAllUsers() {
		List<Users> users = userService.getAllUsers();
		
		return users.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@GetMapping("/users/{id}")
	public UserDto getUserById(@PathVariable Long id) {
		Optional<Users> user = userService.getUserById(id);
		return convertToDto(user.get());
	}
	
	private UserDto convertToDto(Users user) {
		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), convertToDto(user.getFestival()));
		
	}
	
	private List<FestivalDto> convertToDto(List<Festival> festival) {
		return festival.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private FestivalDto convertToDto(Festival festival) {
		return new FestivalDto(festival.getId(), festival.getUser(), festival.getName(), festival.getEventDesc(), festival.getDateFrom(), festival.getDateTo(), festival.getLogoUrl(), festival.getFacebook(), 
				festival.getTwitter(), festival.getLocation());
		}

}
