package com.example.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		User save = userRepository.save(user);
		return save;
	}

}
