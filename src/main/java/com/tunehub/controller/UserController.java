package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.LoginData;
import com.tunehub.entity.Song;
import com.tunehub.entity.Users;
import com.tunehub.service.SongService;
import com.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	UserService us;
	@Autowired
	SongService ss;
	
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
	//public String validation(@RequestParam("email") String email,@RequestParam("password") String password
	//,HttpSession session, Model model) insteed of the code to change the below
	public String validation(@RequestBody LoginData data,HttpSession session, Model model) {
		System.out.println("call Recied");
		//extract the email and password
		String email=data.getEmail();
		String password=data.getPassword();
	
		if(us.validUser(email,password)==true) {
			String role=us.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminHome";
			}
			else {
				//email checking is primium are not
				Users user=us.getUser(email);
				boolean userStatus=user.isPrimium();
				//geting songs
				List<Song> songList=ss.fetchAllSongs();
		        model.addAttribute("songs", songList);
				model.addAttribute("isPrimium", userStatus);
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
