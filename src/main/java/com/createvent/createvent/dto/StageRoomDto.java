package com.createvent.createvent.dto;

import com.createvent.createvent.entity.Festival;

import lombok.Data;

@Data
public class StageRoomDto {

	private Long id;

	private String name;

	private Festival festival;

	private byte[] timetableFile;
}
