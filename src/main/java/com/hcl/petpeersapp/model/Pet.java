package com.hcl.petpeersapp.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Pets")
public class Pet implements Serializable {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petId;
	@Column(name = "Name")
	private String name;
	@Column(name = "Age")
	private Integer age;
	@Column(name = "Place")
	private String place;
	@ManyToOne
	@JoinColumn(name = "User_Id")
	private User owner;
	public Pet(long petId, String name, Integer age, String place, User owner) {
		super();
		this.petId = petId;
		this.name = name;
		this.age = age;
		this.place = place;
		this.owner = owner;
	}
	public Pet() {
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
}
