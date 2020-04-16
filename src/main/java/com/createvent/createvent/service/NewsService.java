package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.NewsRepository;
import com.createvent.createvent.dto.NewsDto;
import com.createvent.createvent.dto.NewsNewsDto;
import com.createvent.createvent.entity.News;
import com.createvent.createvent.entity.Performer;

import lombok.RequiredArgsConstructor;

@Service
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class NewsService {
	
	private final NewsRepository newsRepository;
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<News> getNewsList() {
		return (List<News>) newsRepository.findAll();
	}
	
	public Optional<News> findById(Long id) {
		return newsRepository.findById(id);
	}
	
	public List<News> getNewsByFestivalId(Long id) {
		return newsRepository.findNewsByFestivalId(id);
	}
	
	public News save(News newsItem) {
//		News news = modelMapper.map(newsItem, News.class);
		return newsRepository.save(newsItem);
	}
	
	public void deleteById(Long id) {
		newsRepository.deleteById(id);
	}

}
