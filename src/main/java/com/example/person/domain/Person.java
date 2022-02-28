package com.example.person.domain;

public class Person {

	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private Integer height;
	
	

	public Person() {
		super();
	}

	public Person(Integer id, String name, Integer age, Integer height) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	
}
