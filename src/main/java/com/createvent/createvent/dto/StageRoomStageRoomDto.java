package com.createvent.createvent.dto;

import lombok.Data;

@Data
public class StageRoomStageRoomDto {

	private Long id;
	
	private String name;

	private StageRoomFestivalDto festival;
	
	public StageRoomStageRoomDto(Long id, String name, StageRoomFestivalDto festival) {
		this.id = id;
		this.name = name;
		this.festival = festival;
	}
}
