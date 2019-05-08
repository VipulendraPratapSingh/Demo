package com.hcl.petpeersapp.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.petpeersapp.dto.PetDTO;
import com.hcl.petpeersapp.model.Pet;
import com.hcl.petpeersapp.services.PetServiceImpl;

import ch.qos.logback.classic.Logger;

@RestController("/pets")
public class PetController {

	private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PetServiceImpl petServiceImpl;

	@GetMapping("/getallpets")
	public List<Pet> petHome() {
		LOGGER.info("******************getAllPets****************");
		return petServiceImpl.getAllPets();
	}

	@PostMapping("/addPet")
	public ResponseEntity<String> addPet(@RequestBody PetDTO petDto) {
		return petServiceImpl.savePet(petDto);
	}

	@GetMapping("/mypets/{userId}")
	public Pet myPets(@PathVariable("userId") long userId) {
		LOGGER.info("***********userId*************");
		return petServiceImpl.getMyPets(userId);
	}

	@GetMapping("/mypets/{userId}/{petId}")
	public ResponseEntity<?> buyPet(@PathVariable("petId") Long petId, @PathVariable("userId") Long userId) {
		return petServiceImpl.buyPet(petId, userId);
	}

}
