package com.example.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecuritydemo.model.CustomUserDetails;
import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user=repo.findByName(name);
		CustomUserDetails userDetails=null;
		if(user!=null) {
			userDetails=new CustomUserDetails();
			userDetails.setUser(user);
		}
		else {
			throw new UsernameNotFoundException("User not exist with name: "+name);
		}
		return userDetails;
	}

}
