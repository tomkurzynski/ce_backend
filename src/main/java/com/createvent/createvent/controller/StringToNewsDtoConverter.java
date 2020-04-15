package com.createvent.createvent.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.createvent.createvent.dto.NewsNewsDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class StringToNewsDtoConverter implements Converter<String, NewsNewsDto>{
	
	@Autowired
    private ObjectMapper objectMapper;
	
	 @Override
	    @SneakyThrows
	    public NewsNewsDto convert(String source) {
	        return  objectMapper.readValue(source, NewsNewsDto.class);
	    }
  
}
