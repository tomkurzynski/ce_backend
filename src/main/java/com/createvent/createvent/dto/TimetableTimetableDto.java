package com.createvent.createvent.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TimetableTimetableDto {

	private Long id;
	private String name;
	
	@JsonIgnore
	private TimetableStageRoomDto stageRoom;
	
	List<PerformerDto> performers;

	public TimetableTimetableDto(Long id, String name, TimetableStageRoomDto stageRoom,
			List<PerformerDto> performers) {
		this.id = id;
		this.name = name;
		this.stageRoom = stageRoom;
		this.performers = performers;
	}
	
	
	
}
