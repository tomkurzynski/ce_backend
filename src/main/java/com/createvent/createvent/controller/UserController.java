package com.createvent.createvent.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dto.FestivalDto;
import com.createvent.createvent.dto.UserDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Users;
import com.createvent.createvent.service.UserService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public boolean login(@RequestBody UserDto user) {
		return user.getEmail().equalsIgnoreCase("name") && user.getPassword().equals("password");
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
	@GetMapping("/user")
	public Principal user(HttpServletRequest request) {
			
		String authToken = request.getHeader("Authorization")
				.substring("Basic".length()).trim();
		return () ->  new String(Base64.getDecoder()
		          .decode(authToken)).split(":")[0];

	}
			
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
	
	@GetMapping("{email}")
	public UserDto getUserByEmail(@PathVariable String email) {
		Users user = userService.getByEmail(email);
		return convertToDto(user);
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
