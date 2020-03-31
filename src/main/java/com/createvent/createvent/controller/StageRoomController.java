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

import com.createvent.createvent.dto.StageRoomFestivalDto;
import com.createvent.createvent.dto.StageRoomStageRoomDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.StageRoom;
import com.createvent.createvent.service.StageRoomService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StageRoomController {
	
	@Autowired
	private StageRoomService stageRoomService;
	
	//get all
	@GetMapping("/stage")
	public List<StageRoomStageRoomDto> getAllRooms() {
		List<StageRoom> stageRooms = stageRoomService.getStageRoomList();
		return stageRooms.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//get by id
	@GetMapping("/stage/{id}")
	public StageRoomStageRoomDto getRoomById(@PathVariable Long id) {
		Optional<StageRoom> stageRoom = stageRoomService.getStageRoomById(id);
		return convertToDto(stageRoom.get());
	}
	
	//add
	@PostMapping("/stage")
	@ResponseStatus(HttpStatus.CREATED)
	public void addRoom(@RequestBody StageRoom stageRoom) {
		stageRoomService.save(stageRoom);
	}
	
	//update
	@PutMapping("/stage/update/{id}")
	public void updateStageRoom(@PathVariable Long id, @Valid @RequestBody StageRoom stageRoom) {
		stageRoomService.save(stageRoom);
	}
	
	//delete
	@DeleteMapping("/stage/delete/{id}")
	public void deleteStageRoom(@PathVariable Long id) {
		stageRoomService.delete(id);
	}

	private StageRoomStageRoomDto convertToDto(StageRoom stageRoom) {
		return new StageRoomStageRoomDto(stageRoom.getId(),
				stageRoom.getName(),
				convertToDto(stageRoom.getFestival()));
	}

	private StageRoomFestivalDto convertToDto(Festival festival) {
		return new StageRoomFestivalDto(festival.getId());
	}
}
