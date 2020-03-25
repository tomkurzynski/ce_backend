package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.createvent.createvent.dao.NewsRepository;
import com.createvent.createvent.entity.News;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class NewsService {
	
	private final NewsRepository newsRepository;
	
	public List<News> findAll() {
		return newsRepository.findAll();
	}
	
	public Optional<News> findById(Long id) {
		return newsRepository.findById(id);
	}
	
	public News save(News newsItem) {
		return newsRepository.save(newsItem);
	}
	
	public void deleteById(Long id) {
		newsRepository.deleteById(id);
	}

}
