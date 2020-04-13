package com.createvent.createvent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Timetable;

@CrossOrigin(origins = "*")
public interface TimetableRepository extends JpaRepository<Timetable, Long>{
	
	List<Timetable> findByStageRoomId(Long id);
}
