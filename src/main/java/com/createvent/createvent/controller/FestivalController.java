package com.createvent.createvent.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dao.FestivalRepository;
import com.createvent.createvent.dto.FestivalDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.service.FestivalService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class FestivalController {

//	@Autowired
//	FestivalRepository festivalRepository;
	
	@Autowired
	private FestivalService festivalService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//get all
	@GetMapping(value = "/festivals")
	public List<FestivalDto> getAllFestivals() {
		List<Festival> festivals = festivalService.getFestivalList();
		
		return festivals.stream().map(this.convertToDto).collect(Collectors.toList());
		
		
	}
	
	//get by id
	
	//update - edit
	
	//delete
	

	private FestivalDto convertToDto(Festival festival) {
		FestivalDto festivalDto = modelMapper.map(festival, FestivalDto.class);
		return festivalDto;
	}

}


