package com.learning.course.model;

public class Student {
	
	private String name;
	private int age;
	private String email;
	
	public Student() {
	}

	public Student(String naem, int age, String email) {
		this.name = naem;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
