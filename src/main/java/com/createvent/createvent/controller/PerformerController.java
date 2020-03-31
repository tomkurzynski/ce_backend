package com.createvent.createvent.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dto.PerformerFestivalDto;
import com.createvent.createvent.dto.PerformerPerformerDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Performer;
import com.createvent.createvent.service.PerformerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PerformerController {

	@Autowired
	private PerformerService performerService;
	
	//get all
	@GetMapping("/performers")
	public List<PerformerPerformerDto> getAllPerformers() {
		List<Performer> performers = performerService.getPerformerList();
		return performers.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//get by id
	@GetMapping("/performers/{id}")
	public PerformerPerformerDto getPerformerById(@PathVariable Long id) {
		Optional<Performer> performer = performerService.getPerformerById(id);
		return convertToDto(performer.get());
	}
	
	//add
	@PostMapping("/performers")
	@ResponseStatus(HttpStatus.CREATED)
	public void addPerformer(@RequestBody Performer performer) {
		performerService.save(performer);
	}
	
	//update
	@PutMapping("/performers/update/{id}")
	public void updatePerformer(@PathVariable Long id, @Valid @RequestBody Performer performer) {
		performerService.save(performer);
	}
	
	//delete
	@DeleteMapping("/performers/delete/{id}")
	public void deletePerformer(@PathVariable Long id) {
		performerService.delete(id);
	}
	
	private PerformerPerformerDto convertToDto(Performer performer) {
		return new PerformerPerformerDto(performer.getId(),
										performer.getName(),
										performer.getDescription(),
										performer.getWebUrl(),
										performer.getFacebook(),
										performer.getYoutube(),
										performer.getTwitter(),
										performer.getSpotify(),
										convertoToDto(performer.getFestival()));
	}

	private PerformerFestivalDto convertoToDto(Festival festival) {
		return new PerformerFestivalDto(festival.getId());
	}


}
