package com.hcl.petpeersapp.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.petpeersapp.dto.PetDTO;
import com.hcl.petpeersapp.model.Pet;
import com.hcl.petpeersapp.model.User;
import com.hcl.petpeersapp.repository.PetRepository;
import com.hcl.petpeersapp.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTestCase {

	@Mock
	PetRepository petRepository;
	@Mock
	UserRepository userRepository;

	@InjectMocks
	private PetServiceImpl petServiceImpl;

	static List<Pet> petlist = new ArrayList();
	static PetDTO petDTO = null;
	static List<Pet> expectedvalueList = null;
	static Pet pet = null;
	static User user = null;
	static Pet expectedPetValue = null;
	ResponseEntity<String> responseEntiry = new ResponseEntity<String>("Successfully-added", HttpStatus.OK);
	ResponseEntity<String> responseDataEntiry = new ResponseEntity<String>("Successfully purchased", HttpStatus.OK);;

	@BeforeClass
	public static void setBeforeInitize() {
		pet = new Pet();
		pet.setPetId(1L);
		pet.setAge(10);
		pet.setName("camel");
		pet.setPlace("Banglore");
		petlist.add(pet);
		expectedvalueList = new ArrayList<Pet>();
		expectedvalueList.add(pet);
		expectedPetValue = new Pet();
		user = new User();
		user.setUserId(1L);
		user.setUserName("nilu");
		user.setTelephone("3434");
		user.setEmailId("vihj@hcl.com");
		user.setPassword("HCL@hcl.com");
		petDTO = new PetDTO();
		petDTO.setAge(12);
		petDTO.setName("carry");
		petDTO.setPlace("delhi");
	}

	@Test
	public void savePetDetailTest() {
		ResponseEntity<?> result = petServiceImpl.savePet(petDTO);
		System.out.println(":::::::::::result::::::::::::" + result);
		Assert.assertEquals(responseEntiry, result);
	}

	@Test
	public void getAllPetsTest() {
		Mockito.when(petRepository.findAll()).thenReturn(expectedvalueList);
		List<Pet> petList = petServiceImpl.getAllPets();
		Assert.assertEquals(expectedvalueList.size(), petList.size());
	}

	@Test
	public void getMyPetsTest() {
		Mockito.when(petRepository.findById(1L).get()).thenReturn(expectedPetValue);
		Pet petActual = petServiceImpl.getMyPets(1L);
		Assert.assertEquals(expectedPetValue, petActual);
	}

	@Test
	public void buyPetTest() {
		Mockito.when(petRepository.findById(1L).get()).thenReturn(pet);
		Mockito.when(userRepository.findById(1L).get()).thenReturn(user);
		Mockito.when(petRepository.save(pet)).thenReturn(pet);
		ResponseEntity<?> result = petServiceImpl.buyPet(1L, 1L);
		System.out.println("result::" + result);
		Assert.assertEquals(responseDataEntiry, result);

	}
}
