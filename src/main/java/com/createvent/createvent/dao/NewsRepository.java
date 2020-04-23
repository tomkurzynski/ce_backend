package com.createvent.createvent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.entity.News;

@CrossOrigin(origins = "*")
public interface NewsRepository extends JpaRepository<News, Long>{
	
	List<News> findNewsByFestivalId(Long id);

}
