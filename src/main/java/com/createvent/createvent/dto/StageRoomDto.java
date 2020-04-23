package com.createvent.createvent.dto;

import java.util.List;

import com.createvent.createvent.entity.Festival;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class StageRoomDto {

	private Long id;

	private String name;

	@JsonIgnore
	private Festival festival;

	@JsonIgnore
	private List<TimetableDto> timetables;
}
