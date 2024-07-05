package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


import com.tunehub.entity.LoginData;
import com.tunehub.entity.Song;
import com.tunehub.entity.Users;
import com.tunehub.service.SongService;
import com.tunehub.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UsersController {
	@Autowired
	UserService service;
	
	@Autowired
	SongService songService;
	
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		boolean userStatus = service.emailExist(user.getEmail());
		if(userStatus  == false) {
			service.addUser(user);	
		}
		return "login";	
	}
	
	@PostMapping("/login")
	public String validate(@RequestParam("email")String email,
			@RequestParam("password") String password, HttpSession session, Model model) {
		
		
		if(service.validUser(email,password) == true) {
			String role= service.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminHome";
			}else {
				Users user = service.getUser(email);
				boolean userStatus = user.isPrimium();
				
				List<Song> songsList = songService.fetchAllSongs();
				model.addAttribute("songs", songsList);
				
				model.addAttribute("isPremium", userStatus);
				
				return "customerHome";
			}
		}else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "login";
	}
	
}



















