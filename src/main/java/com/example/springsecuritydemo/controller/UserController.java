package com.example.springsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping("/hello")
	public String hello() {
		
		return "Hello";
	}

	@PostMapping("user/add")
	public String addUser(@RequestBody User user) {
		
		  String pwd=user.getPassword(); String encryptPwd=passwordEncoder.encode(pwd);
		  user.setPassword(encryptPwd);
		 
		
		userservice.addUser(user);
		
		return "User added";
	}
}
