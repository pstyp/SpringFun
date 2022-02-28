package com.example.person.web;

import java.util.ArrayList;
import java.util.List;

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

@RestController // tells Spring this is a controller :)
// Rest compliant (Representational State Transfer)
public class PersonController {

	@GetMapping("/helloWorld") // THIS IS AN ENDPOINT!!!1111
	public String hello() {
		return "Hello world!";
	}

	// ResponseEntity - an extension of HttpEntity that represents an Http response
	// including
	// status, headers and body

	private List<Person> peeps = new ArrayList<>();

	@PostMapping("/create") // @RequestBody pulls the parameter from the body of the request

	public ResponseEntity<Person> createPerson(@RequestBody Person p) {
		this.peeps.add(p);
		Person created = this.peeps.get(this.peeps.size() - 1);
		ResponseEntity<Person> response = new ResponseEntity<Person>(created, HttpStatus.CREATED); // 201 - created
		return response;
	}
	
	@GetMapping("/getAll") 
	public ResponseEntity<List<Person>> getAllPeeps() {
		return ResponseEntity.ok(this.peeps); //200 - ok
	}
	
	@GetMapping("/get/{id}")  // 200 ok
	public Person getPerson(@PathVariable Integer id) {
		return this.peeps.get(id);
	}
	@PutMapping("/replace/{id}") // 202 accepted
	public ResponseEntity<Person> replacePerson(@PathVariable Integer id, @RequestBody Person newPerson) {
		Person body = this.peeps.set(id, newPerson);
		ResponseEntity<Person> response = new ResponseEntity<Person>(body, HttpStatus.ACCEPTED);
		return response;
	}
	@DeleteMapping("/remove/{id}") // 204 no content 
	public ResponseEntity<?> removePerson(@PathVariable Integer id) {
		this.peeps.remove(id.intValue());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
