package com.example.person.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.person.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
	
	// SPRING WILL AUTO-GENERATE ALL OF THE BASIC CRUD FUNCTIONALITY :) 

}
