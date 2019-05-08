package com.hcl.petpeersapp.dto;

import java.io.Serializable;

public class UserDetailsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String confirmpassword;
	private String telephone;
	private String emailId;

	public UserDetailsDTO() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [userName=" + userName + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", telephone=" + telephone + ", emailId=" + emailId + "]";
	}
}
