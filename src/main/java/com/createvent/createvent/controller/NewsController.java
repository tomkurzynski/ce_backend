package com.createvent.createvent.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dto.NewsFestivalDto;
import com.createvent.createvent.dto.NewsNewsDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.News;
import com.createvent.createvent.service.NewsService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/news")
	public List<NewsNewsDto> getAllNews() {
		List<News> news = newsService.getNewsList();
		return news.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public NewsNewsDto convertToDto(News news) {
		return new NewsNewsDto(news.getId(),
		news.getTitle(),
		news.getNewsBody(),
		news.getDateCreated(),
		news.getLastUpdated(),
		convertToDto(news.getFestival()));
	}

	private NewsFestivalDto convertToDto(Festival festival) {
		return new NewsFestivalDto(festival.getId());
	}

	
}
