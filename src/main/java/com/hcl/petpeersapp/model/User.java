package com.hcl.petpeersapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pet_user")
public class User implements Serializable {
	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Column(name = "User_Name")
	private String userName;
	@Column(name = "Password")
	private String password;
	@Transient
	private String confirmpassword;
    @Column(name = "Telephone")
	private String telephone;
	@Column(name = "Email_Id")
	private String emailId;
	
	public User(long userId, String userName, String password, String confirmpassword, String telephone,
			String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.telephone = telephone;
		this.emailId = emailId;
	}

	public User() {
		
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}