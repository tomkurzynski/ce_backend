package com.createvent.createvent.service;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.createvent.createvent.dao.FestivalRepository;

import com.createvent.createvent.entity.Festival;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FestivalService {

	private final FestivalRepository festivalRepository;
	
	public List<Festival> getFestivalList() {

		
		Page<Festival> festivals = (Page<Festival>) festivalRepository.findAll();
		return festivals.getContent();
	}
	
	
}
