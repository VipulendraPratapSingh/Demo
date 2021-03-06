package com.hcl.petpeersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.petpeersapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String password);
}
