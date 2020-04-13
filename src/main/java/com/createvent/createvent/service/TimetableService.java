package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createvent.createvent.dao.TimetableRepository;
import com.createvent.createvent.dto.TimetableTimetableDto;
import com.createvent.createvent.entity.Timetable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TimetableService {
	
	private final TimetableRepository timetableRepository;
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	
	//get all
	public List<Timetable> getTimetables() {
		return timetableRepository.findAll();
	}
	
	public List<Timetable> getTimetableByStageId(Long id) {
		return timetableRepository.findByStageRoomId(id);
	}
	
	//get by id
	public Optional<Timetable> getById(Long id) {
		return timetableRepository.findById(id);
	}
	
	//save
	public void save(TimetableTimetableDto timetableDto) {
		Timetable timetable = modelMapper.map(timetableDto, Timetable.class);
		timetableRepository.save(timetable);
	}
	
	//delete
	public void delete(Long id) {
		timetableRepository.deleteById(id);
	}

}
