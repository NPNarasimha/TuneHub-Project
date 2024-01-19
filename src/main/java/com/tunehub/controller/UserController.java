package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.Users;
import com.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {
	@Autowired
	UserService us;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
	{	
		Boolean userStatus=us.emailExist(user.getEmail());
		if(userStatus==false) {
			us.addUser(user);
		}
		else {
			System.out.println("User Already Exist");
		}
		
		return "home";   
	}
	
	@PostMapping("/login")
	public String validation(@RequestParam("email") String email,@RequestParam("password") String password
		,HttpSession session) {
		if(us.validUser(email,password)==true) {
			String role=us.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminHome";
			}
			else {
				return "customerHome";
			}
		}
		else {
			return "login";
		}
		
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
