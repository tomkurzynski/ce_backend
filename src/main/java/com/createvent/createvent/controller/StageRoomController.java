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

import com.createvent.createvent.dto.StageRoomFestivalDto;
import com.createvent.createvent.dto.StageRoomStageRoomDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.StageRoom;
import com.createvent.createvent.service.StageRoomService;

@RestController
@RequestMapping("/api/stage")
@CrossOrigin(origins = "*")
public class StageRoomController {
	
	@Autowired
	private StageRoomService stageRoomService;
	
	@Autowired
	private StringToStageDtoConverter stageRoomConverter;
	
	//get all
	@GetMapping("/list/{id}")
	public List<StageRoomStageRoomDto> getAllRooms(@PathVariable Long id) {
		List<StageRoom> stageRooms = stageRoomService.get(id);
		return stageRooms.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//get by id
	@GetMapping("/{id}")
	public StageRoomStageRoomDto getRoomById(@PathVariable Long id) {
		Optional<StageRoom> stageRoom = stageRoomService.getStageRoomById(id);
		return convertToDto(stageRoom.get());
	}
	
	@PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public StageRoomStageRoomDto upload(@RequestPart(name = "file", required = false) MultipartFile file,
			@RequestPart("room") String room) throws IOException {
		StageRoomStageRoomDto stageConverted = stageRoomConverter.convert(room);
		if (file != null) {
			stageConverted.setTimetableFile(file.getBytes());
		}

		stageRoomService.save(stageConverted);
		return stageConverted;
	}
	
	@PostMapping
	public StageRoomStageRoomDto upload(@RequestBody StageRoomStageRoomDto stageRoomDto) {
	
		
		stageRoomService.save(stageRoomDto);
		return stageRoomDto;
	
	}
	
	//update
	@PutMapping(value = "/save/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public StageRoomStageRoomDto update(@PathVariable Long id, @Valid @RequestPart(name = "file", required = false) MultipartFile file,
						 @RequestPart("room") String room) throws IOException {
		StageRoomStageRoomDto stageConverted = stageRoomConverter.convert(room); 
		if(file != null) {
			stageConverted.setTimetableFile(file.getBytes());
		}
		
		stageRoomService.save(stageConverted);
		return stageConverted;
	
	}
	
	//delete
	@DeleteMapping("/{id}")
	public void deleteStageRoom(@PathVariable Long id) {
		stageRoomService.delete(id);
	}

	private StageRoomStageRoomDto convertToDto(StageRoom stageRoom) {
		return new StageRoomStageRoomDto(stageRoom.getId(),
				stageRoom.getName(),
				convertToDto(stageRoom.getFestival()),
				stageRoom.getTimetableFile());
	}

	private StageRoomFestivalDto convertToDto(Festival festival) {
		return new StageRoomFestivalDto(festival.getId());
	}
}
