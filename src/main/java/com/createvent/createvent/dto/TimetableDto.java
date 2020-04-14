package com.createvent.createvent.dto;

import com.createvent.createvent.entity.StageRoom;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TimetableDto {

	private Long id;
	private String name;
	
	@JsonIgnore
	private StageRoom stageRoom;
	
	@JsonIgnore
	private byte[] file;

	public TimetableDto(Long id, String name, StageRoom stageRoom, byte[] file) {
		this.id = id;
		this.name = name;
		this.stageRoom = stageRoom;
		this.file = file;
	}	
}
