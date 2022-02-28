package com.example.person.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.person.domain.Person;

@Service
public class PersonService {

	private List<Person> peeps = new ArrayList<>();

	// CREATE
	public Person createPerson(Person p) {
		this.peeps.add(p);
		Person created = this.peeps.get(this.peeps.size() - 1);
		return created;
	}

	// READ
	public List<Person> getAllPeeps() {
		return this.peeps;
	}

	public Person getPerson(Integer id) {
		return this.peeps.get(id);
	}

	// UPDATE
	public Person replacePerson(Integer id, Person newPerson) {
		Person body = this.peeps.set(id, newPerson);
		return body;
	}

	// DELETE
	public void removePerson(@PathVariable Integer id) {
		this.peeps.remove(id.intValue());
	}
}