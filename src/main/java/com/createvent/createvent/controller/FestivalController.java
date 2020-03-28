package com.createvent.createvent.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dao.FestivalRepository;
import com.createvent.createvent.dto.FestivalDto;
import com.createvent.createvent.dto.UserDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Users;
import com.createvent.createvent.service.FestivalService;
import com.createvent.createvent.service.UserService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class FestivalController {

//	@Autowired
//	FestivalRepository festivalRepository;
	
	@Autowired
	private FestivalService festivalService;
	
	@Autowired
	private UserService userService;
	
	
	//get all
	@GetMapping(value = "/festivals")
	public List<FestivalDto> getAllFestivals() {
		List<Festival> festivals = festivalService.getFestivalList();
		
		return festivals.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//get by id
	
	//update - edit
	
	//delete
	

	private FestivalDto convertToDto(Festival festival) {
		return new FestivalDto(festival.getId(), 
				festival.getUser(),
				festival.getName(), 
				festival.getEventDesc(), 
				festival.getDateFrom(), 
				festival.getDateTo(), 
				festival.getLogoUrl(),
				festival.getFacebook(),
				festival.getTwitter(),
				festival.getLocation()	
				);
	}

//	
//	private UserDto convertToDto(Users user) {
//		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getFestival());
//	}

}


