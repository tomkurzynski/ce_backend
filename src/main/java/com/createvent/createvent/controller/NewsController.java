package com.createvent.createvent.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.entity.News;
import com.createvent.createvent.service.NewsService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class NewsController {
	private NewsService newsService;

	public NewsController(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@GetMapping("/news")
	public List<News> getAllNews() {
		return newsService.findAll();
	}

}
