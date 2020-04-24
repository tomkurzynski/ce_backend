package com.createvent.createvent.dto;

import lombok.Data;

@Data
public class StageRoomStageRoomDto {

	private Long id;
	
	private String name;

	private StageRoomFestivalDto festival;
	
	private byte[] timetableFile;
		
	public StageRoomStageRoomDto(Long id, String name, StageRoomFestivalDto festival, byte[] timetableFile) {
		this.id = id;
		this.name = name;
		this.festival = festival;
		this.timetableFile = timetableFile;
	}
}
