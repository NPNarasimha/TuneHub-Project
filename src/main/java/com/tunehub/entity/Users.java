package com.tunehub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
String userName;
String email;
String password;
String gender;
String role;
String address;
boolean isPrimium;
public Users() {
	super();
	// TODO Auto-generated constructor stub
}
public Users(int id, String userName, String email, String password, String gender, String role, String address,
		boolean isPrimium) {
	super();
	this.id = id;
	this.userName = userName;
	this.email = email;
	this.password = password;
	this.gender = gender;
	this.role = role;
	this.address = address;
	this.isPrimium = isPrimium;
}
@Override
public String toString() {
	return "Users [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", gender="
			+ gender + ", role=" + role + ", address=" + address + ", isPrimium=" + isPrimium + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public boolean isPrimium() {
	return isPrimium;
}
public void setPrimium(boolean isPrimium) {
	this.isPrimium = isPrimium;
}



}
