package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.dao.UserRepository;
import com.createvent.createvent.dto.UserRegDto;
import com.createvent.createvent.entity.Users;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<Users> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public Users getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void save(UserRegDto userRegDto) {
		Users user = new Users();
		user.setEmail(userRegDto.getEmail());
		user.setFirstName(userRegDto.getFirstName());
		user.setLastName(userRegDto.getLastName());
		user.setPassword(passwordEncoder.encode(userRegDto.getPassword()));
		userRepository.save(user);
	}
}
