package com.practice.springbootdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springbootdemo.entity.UserEntity;
import com.practice.springbootdemo.exceptions.ResourceNotFoundException;
import com.practice.springbootdemo.repository.UserRepository;

@RestController //@Controller @ResponseBody
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
//	@GetMapping
//	public String getUser()
//	{
//		return "Welcome to Programming World";
//	}
	
	
	@GetMapping
	public List<UserEntity> getUsers()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this id:"+id));
	}
	
	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);		
	}
	
	@PutMapping("/{id}")
	public UserEntity updateUser(@PathVariable Long id,@RequestBody UserEntity user)
	{
		UserEntity userData = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not founf with this id:"+id));
		userData.setEmail(user.getEmail());
		userData.setName(user.getName());
		return userRepository.save(userData);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id)
	{
		UserEntity userData = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not founf with this id:"+id));
		userRepository.delete(userData);
		return ResponseEntity.ok().build();
	}
	
	
}
