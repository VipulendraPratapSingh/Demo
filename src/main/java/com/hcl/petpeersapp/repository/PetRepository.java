package com.hcl.petpeersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.petpeersapp.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
