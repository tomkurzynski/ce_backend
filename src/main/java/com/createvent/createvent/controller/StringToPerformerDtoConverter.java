package com.createvent.createvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.createvent.createvent.dto.PerformerPerformerDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Component
public class StringToPerformerDtoConverter implements Converter<String, PerformerPerformerDto> {

	 @Autowired
	    private ObjectMapper objectMapper;
	  

	    @Override
	    @SneakyThrows
	    public PerformerPerformerDto convert(String source) {
	        return  objectMapper.readValue(source, PerformerPerformerDto.class);
	    }
}
