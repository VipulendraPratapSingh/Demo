package com.hcl.petpeersapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hcl.petpeersapp.dto.PetDTO;
import com.hcl.petpeersapp.model.Pet;
import com.hcl.petpeersapp.model.User;
import com.hcl.petpeersapp.repository.PetRepository;
import com.hcl.petpeersapp.repository.UserRepository;

@Service
public class PetServiceImpl implements PetService {
	@Autowired
	private PetRepository petRepository;
	@Autowired
	private UserRepository userRepository;
	public ResponseEntity<String> savePet(PetDTO petDto) {
		Pet pet = new Pet();
			pet.setName(petDto.getName());
			pet.setAge(petDto.getAge());
			pet.setPlace(petDto.getPlace());
			petRepository.save(pet);
		return new ResponseEntity<String>("Successfully-added", HttpStatus.OK);
	}
	@Override
	public List<Pet> getAllPets() {
		return petRepository.findAll();
	}
	@Override
	public Pet getMyPets(long userId) {
		return petRepository.findById(userId).get();
	}

	public ResponseEntity<?> buyPet(Long petId, Long userId) {
    Pet pet = petRepository.findById(petId).get();
    User user = userRepository.findById(userId).get();
    pet.setOwner(user);
    petRepository.save(pet);
    return new ResponseEntity<String>("Successfully purchased",HttpStatus.OK);
    
	}
}
