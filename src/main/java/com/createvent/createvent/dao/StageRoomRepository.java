package com.createvent.createvent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.StageRoom;

@CrossOrigin(origins = "*")
public interface StageRoomRepository extends JpaRepository<StageRoom, Long>{
	List<StageRoom> findRoomsByFestivalId(Long id);
}
