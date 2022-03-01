package com.example.person.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.person.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
	
	// SPRING WILL AUTO-GENERATE ALL OF THE BASIC CRUD FUNCTIONALITY :) 
	
	List<Person> findByNameIgnoreCase(String name);
	
	List<Person> findByAge(Integer age);

}
