package com.hcl.petpeersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.petpeersapp.dto.LoginDTO;
import com.hcl.petpeersapp.dto.UserDetailsDTO;
import com.hcl.petpeersapp.model.Pet;
import com.hcl.petpeersapp.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserDetailsDTO userDetailsDTO) {
		return userServiceImpl.addUser(userDetailsDTO);

	}

	@PostMapping("/authenticate")
	public List<Pet> authenticateUser(@RequestBody LoginDTO loginDTO) {
		return userServiceImpl.authenticateUser(loginDTO);

	}
}
