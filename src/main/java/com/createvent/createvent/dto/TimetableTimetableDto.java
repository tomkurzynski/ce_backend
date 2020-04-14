package com.createvent.createvent.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TimetableTimetableDto {

	private Long id;
	private String name;
	
	@JsonIgnore
	private TimetableStageRoomDto stageRoom;
	
	private byte[] file;

	public TimetableTimetableDto(Long id, String name, TimetableStageRoomDto stageRoom, byte[] file) {
		this.id = id;
		this.name = name;
		this.stageRoom = stageRoom;
		this.file = file;
	}

	
	
}
