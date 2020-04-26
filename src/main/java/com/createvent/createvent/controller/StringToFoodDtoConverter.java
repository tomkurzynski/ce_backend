package com.createvent.createvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.createvent.createvent.dto.FoodFoodDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Component
public class StringToFoodDtoConverter implements Converter<String, FoodFoodDto> {

    @Autowired
    private ObjectMapper objectMapper;
  

    @Override
    @SneakyThrows
    public FoodFoodDto convert(String source) {
        return  objectMapper.readValue(source, FoodFoodDto.class);
    }
    
  
}
