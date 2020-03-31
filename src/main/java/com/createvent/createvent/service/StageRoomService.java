package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.createvent.createvent.dao.StageRoomRepository;
import com.createvent.createvent.entity.StageRoom;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StageRoomService {
	private final StageRoomRepository stageRoomRepository;
	
	//view all
	public List<StageRoom> getStageRoomList() {
		return stageRoomRepository.findAll();
	}
	
	//view by id
	public Optional<StageRoom> getStageRoomById(Long id) {
		return stageRoomRepository.findById(id);
	}
	
	//save
	public void save(StageRoom stageRoom) {
		stageRoomRepository.save(stageRoom);
	}
	
	//delete
	public void delete(Long id) {
		stageRoomRepository.deleteById(id);
	}

}
