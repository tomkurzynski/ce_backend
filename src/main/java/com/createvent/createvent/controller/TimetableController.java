package com.createvent.createvent.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dto.PerformerDto;
import com.createvent.createvent.dto.TimetableDto;
import com.createvent.createvent.dto.TimetableStageRoomDto;
import com.createvent.createvent.dto.TimetableTimetableDto;
import com.createvent.createvent.entity.Performer;
import com.createvent.createvent.entity.RunningOrder;
import com.createvent.createvent.entity.StageRoom;
import com.createvent.createvent.entity.Timetable;
import com.createvent.createvent.service.PerformerService;
import com.createvent.createvent.service.TimetableService;

@RestController
@RequestMapping(value = "api/timetables")
@CrossOrigin(origins = "*")
public class TimetableController {
	
	@Autowired
	private TimetableService timetableService;
	
	@Autowired
	private PerformerService performerService;
	
	//get all / all by stage id / by id
	@GetMapping
	public List<TimetableTimetableDto> getAllTimetables() {
		List<Timetable> timetables = timetableService.getTimetables();
		return timetables.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public TimetableTimetableDto getTimetableById(@PathVariable Long id) {
		Optional<Timetable> timetable = timetableService.getById(id);
		return convertToDto(timetable.get());
	}
	
	@GetMapping("/stage/{id}")
	public List<TimetableTimetableDto> getByStageId(@PathVariable Long id) {
		List<Timetable> timetables = timetableService.getTimetableByStageId(id);
		return timetables.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//add
	@PostMapping
	public void addTimetable(@RequestBody TimetableTimetableDto timetable) {
		timetableService.save(timetable);
	}
	
	//update
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @Valid @RequestBody TimetableDto timetable) {
		Optional<Timetable> tempTimetable = timetableService.getById(id);
		
		timetable.setStageRoom(tempTimetable.get().getStageRoom());
		
		timetableService.save(timetable);
	}
	
	//delete
	
	public TimetableTimetableDto convertToDto(Timetable timetable) {
		return new TimetableTimetableDto(timetable.getId(), 
				timetable.getName(), 
				convertStageToDto(timetable.getStageRoom()), 
				convertRunningOrderToDto(timetable.getRunningOrder()));
	}


	private List<PerformerDto> convertRunningOrderToDto(List<RunningOrder> runningOrder) {
		List<Performer> performers = performerService.getPerformerList();
		return performers.stream().map(this::convertPerformerToDto).collect(Collectors.toList());
	}

	private TimetableStageRoomDto convertStageToDto(StageRoom stageRoom) {
		return new TimetableStageRoomDto(stageRoom.getId());
	}
	
	private PerformerDto convertPerformerToDto(Performer performer) {
		return new PerformerDto(performer.getId(), performer.getName());
	}

}
