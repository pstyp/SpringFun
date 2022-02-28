package com.example.person.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // tells Spring this is a controller :)
// Rest compliant (Representational State Transfer)
public class PersonController {

	@GetMapping("/helloWorld") // THIS IS AN ENDPOINT!!!1111
	public String hello() {
		return "Hello world!";
	}
}
