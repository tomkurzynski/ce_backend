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

import com.createvent.createvent.dto.TimetableStageRoomDto;
import com.createvent.createvent.dto.TimetableTimetableDto;
import com.createvent.createvent.entity.StageRoom;
import com.createvent.createvent.entity.Timetable;
import com.createvent.createvent.service.TimetableService;

@RestController
@RequestMapping(value = "api/timetables")
@CrossOrigin(origins = "*")
public class TimetableController {
	
	@Autowired
	private TimetableService timetableService;
		
	@Autowired
	private StringToTimetableDtoConverter timetableConverter;
	
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
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void addTimetable(@RequestPart("file") MultipartFile file,
			 @RequestPart("timetable") String timetable) throws IOException {
		TimetableTimetableDto timetableConverted = timetableConverter.convert(timetable); 
		timetableConverted.setFile(file.getBytes());
		timetableService.save(timetableConverted);
	}
	
	//update
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @Valid @RequestBody TimetableTimetableDto timetable) {
		timetableService.save(timetable);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		timetableService.delete(id);
	}
	
	public TimetableTimetableDto convertToDto(Timetable timetable) {
		return new TimetableTimetableDto(timetable.getId(), 
				timetable.getName(), 
				convertStageToDto(timetable.getStageRoom()),
				timetable.getFile()
				);
	}


	private TimetableStageRoomDto convertStageToDto(StageRoom stageRoom) {
		return new TimetableStageRoomDto(stageRoom.getId());
	}
}
