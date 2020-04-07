package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createvent.createvent.dao.PerformerRepository;
import com.createvent.createvent.dto.PerformerPerformerDto;
import com.createvent.createvent.entity.Performer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformerService {
	private final PerformerRepository performerRepository;
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	
	//list all
	public List<Performer> getPerformerList() {
		return performerRepository.findAll();
	}
	
	//get by id
	public Optional<Performer> getPerformerById(Long id) {
		return performerRepository.findById(id);
	}
	
	//save
	public void save(PerformerPerformerDto performerDto) {
		Performer performer = modelMapper.map(performerDto, Performer.class);
		performerRepository.save(performer);
	}
	
	//delete
	public void delete(Long id) {
		performerRepository.deleteById(id);
	}
}
