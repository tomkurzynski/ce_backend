package com.createvent.createvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.createvent.createvent.dto.FoodFestivalDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Component
public class StringToFestivalDtoConverter implements Converter<String, FoodFestivalDto> {
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	@SneakyThrows
	public FoodFestivalDto convert(String source) {
		return objectMapper.readValue(source, FoodFestivalDto.class);
	}
}
