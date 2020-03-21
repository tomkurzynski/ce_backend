package com.createvent.createvent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createvent.createvent.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
