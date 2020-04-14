package com.createvent.createvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.createvent.createvent.dto.TimetableTimetableDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;

import lombok.SneakyThrows;

@Component
public class StringToTimetableDtoConverter implements Converter<String, TimetableTimetableDto> {

	 	@Autowired
	    private ObjectMapper objectMapper;
	  

	    @Override
	    @SneakyThrows
	    public TimetableTimetableDto convert(String source) {
	        return  objectMapper.readValue(source, TimetableTimetableDto.class);
	    }

}
