package com.createvent.createvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.createvent.createvent.dto.StageRoomStageRoomDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Component
public class StringToStageDtoConverter implements Converter<String, StageRoomStageRoomDto> {
	 	@Autowired
	    private ObjectMapper objectMapper;
	  

	    @Override
	    @SneakyThrows
	    public StageRoomStageRoomDto convert(String source) {
	        return  objectMapper.readValue(source, StageRoomStageRoomDto.class);
	    }
}
