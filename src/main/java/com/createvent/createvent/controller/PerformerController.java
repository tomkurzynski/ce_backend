package com.createvent.createvent.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.createvent.createvent.dto.PerformerFestivalDto;
import com.createvent.createvent.dto.PerformerPerformerDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Performer;
import com.createvent.createvent.service.PerformerService;

@RestController
@RequestMapping("/api/performers")
@CrossOrigin(origins = "*")
public class PerformerController {

	@Autowired
	private PerformerService performerService;
	
	@Autowired
	private StringToPerformerDtoConverter performerConverter;
	
	//get all
	@GetMapping()
	public List<PerformerPerformerDto> getAllPerformers() {
		List<Performer> performers = performerService.getPerformerList();
		return performers.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//get by id
	@GetMapping("{id}")
	public PerformerPerformerDto getPerformerById(@PathVariable Long id) {
		Optional<Performer> performer = performerService.getPerformerById(id);
		return convertToDto(performer.get());
	}
	
	@GetMapping("festival/{id}")
	public List<PerformerPerformerDto> getPerformerByFestivalId(@PathVariable Long id) {
		List<Performer> performers = performerService.getPerformerByFestivalId(id);
		return performers.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//add
//	@PostMapping("/performers")
//	@ResponseStatus(HttpStatus.CREATED)
//	public void addPerformer(@RequestBody Performer performer) {
//		performerService.save(performer);
//	}
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public PerformerPerformerDto upload(@RequestPart("file") MultipartFile file,
						 @RequestPart("performer") String performer) throws IOException {
		PerformerPerformerDto performerConverted = performerConverter.convert(performer); 
		performerConverted.setPhoto(file.getBytes());
		performerService.save(performerConverted);
		return performerConverted;
	
	}
	
	//update
//	@PutMapping("/performers/update/{id}")
//	public void updatePerformer(@PathVariable Long id, @Valid @RequestBody PerformerPerformerDto performer) {
//		performerService.save(performer);
//	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void updatePerformer(@PathVariable Long id, @Valid @RequestPart("file") MultipartFile file,
			 				@RequestPart("performer") String performer) throws IOException {
		PerformerPerformerDto performerConverted = performerConverter.convert(performer); 
		performerConverted.setPhoto(file.getBytes());
		performerService.save(performerConverted);
	}
	
	//delete
	@DeleteMapping("/{id}")
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
										convertoToDto(performer.getFestival()),
										performer.getPhoto());
	}

	private PerformerFestivalDto convertoToDto(Festival festival) {
		return new PerformerFestivalDto(festival.getId());
	}


}
