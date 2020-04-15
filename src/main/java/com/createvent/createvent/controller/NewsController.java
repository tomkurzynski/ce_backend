package com.createvent.createvent.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.dto.NewsFestivalDto;
import com.createvent.createvent.dto.NewsNewsDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.News;
import com.createvent.createvent.service.NewsService;

@RestController
@RequestMapping(value = "/api/news")
@CrossOrigin(origins = "*")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private StringToNewsDtoConverter newsConverter;
	
	@GetMapping
	public List<NewsNewsDto> getAllNews() {
		List<News> news = newsService.getNewsList();
		return news.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	//get by id
	@GetMapping("/{id}")
	public NewsNewsDto getNewsById(@PathVariable Long id) {
		Optional<News> news = newsService.findById(id);
		return convertToDto(news.get());
	}
	
	@GetMapping("/festival/{id}")
	public List<NewsNewsDto> getNewsByFestivalId(@PathVariable Long id) {
		List<News> news = newsService.getNewsByFestivalId(id);
		return news.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	
	//add
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void addNews( @RequestPart("news") String newsItem) {
		NewsNewsDto newsConverted = newsConverter.convert(newsItem);
		newsService.save(newsConverted);
	}
	
	//update
	@PutMapping("/{id}")
	public void updateNewsItem(@PathVariable Long id, @Valid @RequestBody NewsNewsDto newsItem) {
		
		Optional<NewsNewsDto> news = newsService.findById(id);
		
		
		newsItem.setFestival(news.get().getFestival());
		
		
		
		newsService.save(newsItem);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public void deleteNewsItem(@PathVariable Long id) {
		newsService.deleteById(id);
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
