package com.createvent.createvent.controller;

import com.createvent.createvent.entity.Food;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.Converter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringToUserConverter implements Converter<String, Food> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public Food convert(String source) {
        return  objectMapper.readValue(source, Food.class);
    }
}
