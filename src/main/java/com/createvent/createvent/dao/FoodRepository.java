package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.Food;

@CrossOrigin(origins = "*")
public interface FoodRepository extends JpaRepository<Food, Long>{

}
