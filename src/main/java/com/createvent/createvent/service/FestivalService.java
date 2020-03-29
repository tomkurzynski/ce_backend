package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.FestivalRepository;
import com.createvent.createvent.dao.UserRepository;
import com.createvent.createvent.entity.Festival;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FestivalService {

	private final FestivalRepository festivalRepository;

	
	public List<Festival> getFestivalList() {
	
//		Page<Festival> festivals = (Page<Festival>) festivalRepository.findAll();
		return festivalRepository.findAll();
	}
	
	public List<Festival> getFestivalById(Long id) {
		return festivalRepository.findById(id);
	}
	
	
	
	
}
