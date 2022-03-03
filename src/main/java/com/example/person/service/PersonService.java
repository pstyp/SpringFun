package com.example.person.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.person.domain.Person;
import com.example.person.repo.PersonRepo;



@Service
public class PersonService implements ServiceIF<Person>{

	private PersonRepo repo;
	
	@Autowired
	public PersonService(PersonRepo repo) {
		super();
		this.repo=repo;
	}
	
	

	// CREATE
	public Person create(Person p) {
		Person created = this.repo.save(p);  
		return created;
	}

	// READ
	public List<Person> getAll() {
		return this.repo.findAll();
	}

	public Person getOne(Integer id) {
		Optional<Person> found = this.repo.findById(id);
		return found.get(); 
		
	}
	
	
	public List<Person> getAllPeepsByAge(Integer age) {
		List<Person> found = this.repo.findByAge(age);
		return found;
	}
	
	public List<Person> getPeepsByName(String name) {
		List<Person> found = this.repo.findByNameIgnoreCase(name);
		return found;
	}

	// UPDATE
	public Person replace(Integer id, Person newPerson) {
		Person existing = this.repo.findById(id).get();
		existing.setAge(newPerson.getAge());
		existing.setHeight(newPerson.getHeight());
		existing.setName(newPerson.getName());
		Person updated = this.repo.save(existing);
		return updated;
	}

	// DELETE
	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id); //DELETE FROM Person WHERE id= 
	}
}