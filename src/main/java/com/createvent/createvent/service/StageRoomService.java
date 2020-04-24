package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createvent.createvent.dao.StageRoomRepository;
import com.createvent.createvent.dto.StageRoomDto;
import com.createvent.createvent.dto.StageRoomStageRoomDto;
import com.createvent.createvent.entity.StageRoom;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StageRoomService {
	private final StageRoomRepository stageRoomRepository;
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	
	//view all
	public List<StageRoom> get(Long id) {
		return stageRoomRepository.findRoomsByFestivalId(id);
	}
	
	//view by id
	public Optional<StageRoom> getStageRoomById(Long id) {
		return stageRoomRepository.findById(id);
	}
	
	//save
	public void save(StageRoomStageRoomDto stageRoomDto) {
		StageRoom stageRoom = modelMapper.map(stageRoomDto, StageRoom.class);
		stageRoomRepository.save(stageRoom);
	}
	
	//delete
	public void delete(Long id) {
		stageRoomRepository.deleteById(id);
	}

}
