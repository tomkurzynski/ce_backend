package com.createvent.createvent.dto;

import java.util.List;

import com.createvent.createvent.entity.Festival;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TimetableStageRoomDto {
	
	private Long id;
	
	@JsonIgnore
	private String name;

	@JsonIgnore
	private Festival festival;
	
	@JsonIgnore
	private List<TimetableDto> timetables;

	public TimetableStageRoomDto(Long id, String name, Festival festival, List<TimetableDto> timetables) {
		this.id = id;
		this.name = name;
		this.festival = festival;
		this.timetables = timetables;
	}

	public TimetableStageRoomDto(Long id) {
		this.id = id;
	}
	
	
}
