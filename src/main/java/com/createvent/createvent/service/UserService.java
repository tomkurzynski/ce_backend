package com.createvent.createvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.createvent.createvent.dao.UserRepository;
import com.createvent.createvent.entity.Users;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<Users> getUserById(Long id) {
		return userRepository.findById(id);
	}

}
