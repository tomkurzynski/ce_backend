package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.UserRepository;
import com.createvent.createvent.dto.UserDto;
import com.createvent.createvent.entity.Users;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserService {
	
	private final UserRepository userRepository;
		
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<Users> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public Users getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void save(UserDto userDto) {
		Users user = new Users();
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
