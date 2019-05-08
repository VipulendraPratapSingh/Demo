package com.hcl.petpeersapp.dto;

import java.io.Serializable;

public class PetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	private String place;

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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "PetDto [name=" + name + ", age=" + age + ", place=" + place + "]";
	}
}
