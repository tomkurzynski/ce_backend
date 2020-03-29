package com.createvent.createvent.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dao.FestivalRepository;
import com.createvent.createvent.dto.FestivalDto;
import com.createvent.createvent.dto.FestivalFestivalDto;
import com.createvent.createvent.dto.FestivalUserDto;
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
	public List<FestivalFestivalDto> getAllFestivals() {
		List<Festival> festivals = festivalService.getFestivalList();
		
		return festivals.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//get by id
	@GetMapping(value = "/festivals/{id}")
	public FestivalFestivalDto Festival(@PathVariable Long id) {
		Optional<com.createvent.createvent.entity.Festival> festival = festivalService.getFestivalById(id);
		return convertToDto(festival.get());
		
	}
	
	//update - edit
	
	//delete
	

	private FestivalFestivalDto convertToDto(Festival festival) {
		return new FestivalFestivalDto(festival.getId(), 
				convertToDto(festival.getUser()),
				festival.getName(),
				festival.getEventDesc(),
				festival.getDateFrom(),
				festival.getDateTo(), 
				festival.getLogoUrl(),
				festival.getFacebook(),
				festival.getTwitter(),
				festival.getLocation());
	}

	private FestivalUserDto convertToDto(Users user) {
		return new FestivalUserDto(user.getId());
	}
}


