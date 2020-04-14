package com.createvent.createvent.dto;
import java.util.List;

import com.createvent.createvent.entity.StageRoom;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TimetableDto {

	private Long id;
	private String name;
	
	@JsonIgnore
	private StageRoom stageRoom;
	
	List<PerformerDto> performers;
	
	public TimetableDto(Long id, String name, StageRoom stageRoom,
			List<PerformerDto> performers) {
		this.id = id;
		this.name = name;
		this.stageRoom = stageRoom;
		this.performers = performers;
	}

	public TimetableDto() {
	}
	
	
	
	
}
