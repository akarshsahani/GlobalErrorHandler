package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create-user")
	public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest userRequest){
		User user = userService.createUser(userRequest);
//		return new ResponseEntity<T>(user, HttpStatus.CREATED);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/all-users")
	public ResponseEntity<List<User>> allUsers(){
		List<User> users = userService.allUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<User>> search(@RequestParam @NotNull @NotEmpty @NotBlank  String search){
		List<User> users =  userService.search(search);
		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}
	
}
