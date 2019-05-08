package com.hcl.petpeersapp.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.petpeersapp.dto.UserDetailsDTO;


@Service
public interface UserService {
	public ResponseEntity<String> addUser(UserDetailsDTO userDetails);
}
