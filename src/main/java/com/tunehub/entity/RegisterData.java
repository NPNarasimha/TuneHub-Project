package com.tunehub.entity;

public class RegisterData {
	String userName;
	String email;
	String password;
	String gender;
	String role;
	String address;
	public RegisterData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterData(String userName, String email, String password, String gender, String role, String address) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.address = address;
	}
	@Override
	public String toString() {
		return "RegisterData [userName=" + userName + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", role=" + role + ", address=" + address + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}