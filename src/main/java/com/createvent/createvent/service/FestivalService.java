package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.FestivalRepository;
import com.createvent.createvent.dto.FestivalFestivalDto;
import com.createvent.createvent.entity.Festival;

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

		if (festival.getId() != null) {
			Optional<Festival> original = this.getFestivalById(festival.getId());

			if (original.isPresent()) {
				festival.setFoods(original.get().getFoods());
				festival.setNews(original.get().getNews());
				festival.setPerformers(original.get().getPerformers());
				festival.setStageRoom(original.get().getStageRoom());
			}
		}

		festivalRepository.save(festival);
	}

	public void delete(Long id) {
		festivalRepository.deleteById(id);
	}

}
