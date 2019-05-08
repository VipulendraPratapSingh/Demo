package com.hcl.petpeersapp.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hcl.petpeersapp.dto.PetDTO;
import com.hcl.petpeersapp.model.Pet;

@Service
public interface PetService {
	public ResponseEntity<String> savePet(PetDTO petDto);
	public List<Pet> getAllPets();
	public Pet getMyPets(long userId);

}
