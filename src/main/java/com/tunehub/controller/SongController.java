package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.Song;
import com.tunehub.service.SongService;


@Controller
public class SongController {
@Autowired
SongService ss;
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song ) {
		Boolean songStatus=ss.songExist(song.getName());
		if(songStatus==false) {
			ss.addSong(song);
			System.out.println("Song Added Successfully");
		}
		else {
			System.out.println("Song Already Exist");  
	}
		return "adminHome";
	}
	
	@GetMapping("/viewSong")
	public String viewSong(Model model) {
		List<Song> songList=ss.fetchAllSongs();
        model.addAttribute("songs", songList);
		return "displaysongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		Boolean premiumUser=false;
		if(premiumUser==true) {
			List<Song> songList=ss.fetchAllSongs();
	        model.addAttribute("songs", songList);
			return "displaysongs";
		}
		else {
			return "makePayment";
		}
		
	}
	
}
