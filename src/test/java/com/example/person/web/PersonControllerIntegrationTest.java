package com.example.person.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.person.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //sets up the MockMVC objects
public class PersonControllerIntegrationTest {

	@Autowired //pull the MockMvc object from the context (like with @Service or @Repository)
	private MockMvc mvc; // class that performs the request (it basically works as postman)
	
	@Autowired
	private ObjectMapper mapper;  // java <-> JSON converter that spring uses
	
	@Test
	void testCreate() throws Exception {
		Person testPerson = new Person(null, "John", 40, 170);
		String testPersonAsJSON=this.mapper.writeValueAsString(testPerson);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testPersonAsJSON);
		
		Person testCreatedPerson = new Person(1, "John", 40, 170);
		String testCreatedPersonAsJSON = this.mapper.writeValueAsString(testCreatedPerson);
		ResultMatcher checkStatus = status().isCreated(); //status 201 - created
		ResultMatcher checkBody = content().json(testCreatedPersonAsJSON); //checks if the body matches my testCreatedPersonAsJson
		
		// sends the request and then checks the status and the body
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
}
