package com.hcl.petpeersapp.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hcl.petpeersapp.dto.LoginDTO;
import com.hcl.petpeersapp.dto.UserDetailsDTO;
import com.hcl.petpeersapp.model.Pet;
import com.hcl.petpeersapp.model.User;
import com.hcl.petpeersapp.repository.PetRepository;
import com.hcl.petpeersapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PetRepository petRepository;
	@Override
	public ResponseEntity<String> addUser(UserDetailsDTO userDetails) {
		User user = new User();
		user.setUserName(userDetails.getUserName());
		user.setTelephone(userDetails.getTelephone());
		user.setEmailId(userDetails.getEmailId());
		user.setPassword(userDetails.getPassword());
		userRepository.save(user);
		return new ResponseEntity<String>("successully data saved",HttpStatus.OK);
	}
	public List<Pet> authenticateUser(LoginDTO loginDTO) {
		User user = userRepository.findByUserName(loginDTO.getUserName());
		List<Pet> pet = null;
	    if(user.getPassword().equals(loginDTO.getPassword())) {
		 pet = petRepository.findAll();
		}
	    return pet;
	}
}
