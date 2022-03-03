package com.example.person.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.domain.Person;
import com.example.person.service.PersonService;

@RestController // tells Spring this is a controller :)
// Rest compliant (Representational State Transfer)
public class PersonController {
	// ResponseEntity - an extension of HttpEntity that represents an Http response
	// including
	// status, headers and body

	private PersonService service;
	
	@Autowired // tells Spring to fetch the PersonService from the context - dependency injection
	public PersonController(PersonService service) {
		super();
		this.service=service;
	}


	@PostMapping("/create") // @RequestBody pulls the parameter from the body of the request

	public ResponseEntity<Person> createPerson(@RequestBody Person p) {
		Person created = this.service.create(p);
		ResponseEntity<Person> response = new ResponseEntity<Person>(created, HttpStatus.CREATED); // 201 - created
		return response;
	}
	
	@GetMapping("/getAll") 
	public ResponseEntity<List<Person>> getAllPeeps() {
		return ResponseEntity.ok(this.service.getAll()); //200 - ok
	}
	
	@GetMapping("/get/{id}")  // 200 ok
	public Person getPerson(@PathVariable Integer id) {
		return this.service.getOne(id);
	}
	@PutMapping("/replace/{id}") // 202 accepted
	public ResponseEntity<Person> replacePerson(@PathVariable Integer id, @RequestBody Person newPerson) {
		Person body = this.service.replace(id, newPerson);
		ResponseEntity<Person> response = new ResponseEntity<Person>(body, HttpStatus.ACCEPTED);
		return response;
	}
	@DeleteMapping("/remove/{id}") // 204 no content 
	public ResponseEntity<?> removePerson(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getByName/{name}") //200 ok
	public ResponseEntity<List<Person>> getPersonByName(@PathVariable String name) {
	List<Person> found = this.service.getPeepsByName(name);
	return ResponseEntity.ok(found);
	}
	
	@GetMapping("/getByAge/{age}")
	public ResponseEntity<List<Person>> getPersonByAge(@PathVariable Integer age) {
		List<Person> found = this.service.getAllPeepsByAge(age);
		return ResponseEntity.ok(found);
	}
}
