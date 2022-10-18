package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public User createUser(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setAge(userRequest.getAge());
		user.setGender(userRequest.getGender());
		user.setSalary(userRequest.getSalary());
		user.setpNumber(userRequest.getpNumber());
		user.setMobNumber(userRequest.getMobNumber());
		userRepo.save(user);
		return userRepo.findByEmail(userRequest.getEmail());
	}

	public List<User> allUsers() {
		return userRepo.findAll();
	}

	public List<User> search(String search) {
		return userRepo.search(search);
	}

}
