package com.createvent.createvent.controller;

import com.createvent.createvent.dto.FoodFoodDto;
import com.createvent.createvent.entity.Food;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringToFoodConverter implements Converter<String, FoodFoodDto> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public FoodFoodDto convert(String source) {
        return  objectMapper.readValue(source, FoodFoodDto.class);
    }
    
   
}
