package com.createvent.createvent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.FestivalRepository;
import com.createvent.createvent.dao.UserRepository;
import com.createvent.createvent.dto.FestivalFestivalDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Food;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FestivalService {

	private final FestivalRepository festivalRepository;
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<Festival> getFestivalList() {
		return festivalRepository.findAll();
	}
	
	public List<Festival> getFestivalByUserId(Long userId) {
		return festivalRepository.findByUserId(userId);
	}
	
	public Optional<Festival> getFestivalById(Long id) {
		return festivalRepository.findById(id);
	}

	public void save(FestivalFestivalDto festivalDto) {
		Festival festival = modelMapper.map(festivalDto, Festival.class);
		festivalRepository.save(festival);
	}
	
	public void delete(Long id) {
		festivalRepository.deleteById(id);
	}
	
	
}
