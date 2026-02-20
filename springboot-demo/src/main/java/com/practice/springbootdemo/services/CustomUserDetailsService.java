package com.practice.springbootdemo.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.practice.springbootdemo.entity.UserEntity;
import com.practice.springbootdemo.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Fetch user from database
		UserEntity user = userRepository.findByUsername(username)
		.orElseThrow(()->new UsernameNotFoundException("User not found")); 
		
		return new User(user.getUsername(),user.getPassword(),Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
	}

}
