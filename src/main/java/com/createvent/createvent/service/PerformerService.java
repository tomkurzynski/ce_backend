package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.createvent.createvent.dao.PerformerRepository;
import com.createvent.createvent.entity.Performer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformerService {
	private final PerformerRepository performerRepository;
	
	//list all
	public List<Performer> getPerformerList() {
		return performerRepository.findAll();
	}
	
	//get by id
	public Optional<Performer> getPerformerById(Long id) {
		return performerRepository.findById(id);
	}
	
	//save
	public void save(Performer performer) {
		performerRepository.save(performer);
	}
	
	//delete
	public void delete(Long id) {
		performerRepository.deleteById(id);
	}
}
