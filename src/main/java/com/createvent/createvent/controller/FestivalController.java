package com.createvent.createvent.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.createvent.createvent.dto.FestivalFestivalDto;
import com.createvent.createvent.dto.FestivalUserDto;
import com.createvent.createvent.dto.FoodDto;
import com.createvent.createvent.dto.NewsDto;
import com.createvent.createvent.entity.Festival;
import com.createvent.createvent.entity.Food;
import com.createvent.createvent.entity.News;
import com.createvent.createvent.entity.Users;
import com.createvent.createvent.service.FestivalService;

@RestController
@RequestMapping(value = "/api/festivals")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FestivalController {

//	@Autowired
//	FestivalRepository festivalRepository;
	
	@Autowired
	private FestivalService festivalService;
	
	@Autowired
	private StringToFestivalDtoConverter festivalConverter;
	
//	@Autowired
//	private UserService userService;
	
	
	//get all
//	@GetMapping()
//	public List<FestivalFestivalDto> getAllFestivals() {
//		
//		List<Festival> festivals = festivalService.getFestivalList();
//		
//		return festivals.stream().map(this::convertToDto).collect(Collectors.toList());
//	}
	
	//get by id
	@GetMapping("/{id}")
	public FestivalFestivalDto Festival(@PathVariable Long id) {
		Optional<com.createvent.createvent.entity.Festival> festival = festivalService.getFestivalById(id);
		
		return convertToDto(festival.get());
		
	}
	
	@GetMapping("/list/{id}")
	public List<FestivalFestivalDto> getByUserId(@PathVariable Long id) {
		List<Festival> festivals = festivalService.getFestivalByUserId(id);
		return festivals.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	 //add
//	@PostMapping("/festivals")
//	@ResponseStatus(HttpStatus.CREATED)
//	@ResponseBody
//	public void addFestival(@RequestBody Festival festival) {
//		festivalService.save(festival);
//	}
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
//	@ResponseBody
	public void addFestival(@RequestPart(name = "file", required = false) MultipartFile file,
			 @RequestPart("festival") String festival) throws IOException {
		FestivalFestivalDto festivalConverted = festivalConverter.convertFestival(festival);
		
		if(file != null) {
			festivalConverted.setLogoUrl(file.getBytes());
		}
		
		festivalService.save(festivalConverted);
	}
	


	//update - edit
	@PutMapping("/{id}")
	public void updateFestival(@PathVariable Long id, @Valid @RequestBody FestivalFestivalDto festival) {
		festivalService.save(festival);
	}
	
	
	//delete
	@DeleteMapping("/{id}")
	public void deleteFestival(@PathVariable Long id) {
		festivalService.delete(id);
	}
	

	private FestivalFestivalDto convertToDto(Festival festival) {

		return new FestivalFestivalDto(festival.getId(), 
				convertToDto(festival.getUser()),
				festival.getName(),
				festival.getEventDesc(),
				festival.getDateFrom(),
				festival.getDateTo(), 
				festival.getLogoUrl(),
				festival.getFacebook(),
				festival.getTwitter(),
				festival.getLocation(),
				convertToDto(festival.getFoods()),
				convertNewsToDto(festival.getNews()));
	}

	private List<FoodDto> convertToDto(List<Food> foods) {
		return foods.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private List<NewsDto> convertNewsToDto(List<News> news) {
		return news.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private FestivalUserDto convertToDto(Users user) {
		return new FestivalUserDto(user.getId());
	}
	
	private FoodDto convertToDto(Food food) {
		return new FoodDto(food.getId(), food.getFoodName());
	}
	
	private NewsDto convertToDto(News news) {
		return new NewsDto(news.getId(), news.getTitle(), news.getDateCreated());
	}
}

