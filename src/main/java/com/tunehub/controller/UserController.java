package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.LoginData;
import com.tunehub.entity.RegisterData;
import com.tunehub.entity.Song;
import com.tunehub.entity.Users;
import com.tunehub.service.SongService;
import com.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String addUser(@RequestBody RegisterData data)
	{	
		String userName = data.getUserName();
	    String email = data.getEmail();
	    String password = data.getPassword();
	    String gender = data.getGender();
	    String role = data.getRole();
	    String address = data.getAddress();
	    
		Boolean userStatus=us.emailExist(email);
		if(userStatus==false) {
			Users user=new Users();
			 user.setUserName(userName);
		        user.setEmail(email);
		        user.setPassword(password);
		        user.setGender(gender);
		        user.setRole(role);
		        user.setAddress(address);
			us.addUser(user);
			return "new";
		}
		return "home";   
	}
	
	@PostMapping("/login")
	//public String validation(@RequestParam("email") String email,@RequestParam("password") String password
	//,HttpSession session, Model model) insteed of the code to change the below
	public String validation(@RequestBody LoginData data,HttpSession session, Model model) {
		
		//extract the email and password
		String email=data.getEmail();
		String password=data.getPassword();
		boolean validUser=us.validUser(email,password);
		if(validUser==true) {
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