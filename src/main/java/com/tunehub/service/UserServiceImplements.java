package com.tunehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Users;
import com.tunehub.repository.UserRepository;
@Service
public class UserServiceImplements implements UserService {
	@Autowired
	UserRepository ur;
	@Override
	public String addUser(Users user) {
		ur.save(user);
		return "user is added";
	}
	@Override
	public Boolean emailExist(String email) {
		if(ur.findByEmail(email)==null) {
			return false;
		}else {
			return true;
		}
		
	}
	@Override
	public Boolean validUser(String email, String password) {
		Users user=ur.findByEmail(email);
		String db_password=user.getPassword();
		if(password.equals(db_password)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public String getRole(String email) {
		Users user=ur.findByEmail(email);
		return user.getRole();

	}
	@Override
	public Users getUser(String email) {
		return ur.findByEmail(email);
	}
	@Override
	public void updateUser(Users user) {
		ur.save(user);
	}
	
	
}
