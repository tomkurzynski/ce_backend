package com.createvent.createvent.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createvent.createvent.entity.News;
import com.createvent.createvent.service.NewsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/news")
@Slf4j
@RequiredArgsConstructor
public class NewsController {
	
	private final NewsService newsService;
	
	@GetMapping
	public ResponseEntity<List<News>> findAll() {
		return ResponseEntity.ok(newsService.findAll());
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<News> update(@PathVariable Long id, @Valid @RequestBody News newsItem) {
		if(!newsService.findById(id).isPresent()) {
			log.error("Cannot find the id: " + id);
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(newsService.save(newsItem));
	}
	
	@PostMapping 
	public ResponseEntity create(@Valid @RequestBody News newsItem) {
		return ResponseEntity.ok(newsService.save(newsItem));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		if(!newsService.findById(id).isPresent()) {
			log.error("Cannot find the id: " + id);
			ResponseEntity.badRequest().build();
		}
		
		newsService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
