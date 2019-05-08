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

import com.hcl.petpeersapp.dto.LoginDTO;
import com.hcl.petpeersapp.dto.UserDetailsDTO;
import com.hcl.petpeersapp.model.Pet;
import com.hcl.petpeersapp.model.User;
import com.hcl.petpeersapp.repository.PetRepository;
import com.hcl.petpeersapp.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTestCase {

	@Mock
	PetRepository petRepository;
	@Mock
	UserRepository userRepository;

	@InjectMocks
	private PetServiceImpl petServiceImpl;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	static User user = null;
	static Pet pet = null;
	static LoginDTO loginDTO = null;
	static UserDetailsDTO userDetailsDTO = null;
	static List<Pet> expectedvalueList = null;
	ResponseEntity<String> responseEntiry = new ResponseEntity<String>("successully data saved",HttpStatus.OK);
	@BeforeClass
	public static void setBeforeInitize() {
		userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setEmailId("viay@gmail.com");
		userDetailsDTO.setPassword("HCL");
		userDetailsDTO.setTelephone("2323");
		loginDTO = new LoginDTO();
		loginDTO.setUserName("Vijay");
		loginDTO.setPassword("HCL@123");
		user = new User();
		user.setUserId(1L);
		user.setUserName("nilu");
		user.setTelephone("3434");
		user.setEmailId("vihj@hcl.com");
		user.setPassword("HCL@hcl.com");
		pet = new Pet();
		pet.setPetId(1L);
		pet.setAge(10);
		pet.setName("camel");
		pet.setPlace("Banglore");
		expectedvalueList = new ArrayList<Pet>();
		expectedvalueList.add(pet);
	
	}
	@Test
	public void authonticationTestCase() {
		Mockito.when(petRepository.findAll()).thenReturn(expectedvalueList);
		Mockito.when(userRepository.findByUserName(loginDTO.getUserName())).thenReturn(user);	
		List<Pet>  pet = userServiceImpl.authenticateUser(loginDTO);
		Assert.assertEquals(expectedvalueList.size(), pet.size());
	}
	@Test
	public void addUserTest() {
		ResponseEntity<?> result= userServiceImpl.addUser(userDetailsDTO);
		Assert.assertEquals(responseEntiry, result);
	}
}
