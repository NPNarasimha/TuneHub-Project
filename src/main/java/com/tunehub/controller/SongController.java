package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tunehub.entity.Song;
import com.tunehub.entity.SongData;
import com.tunehub.service.SongService;

@CrossOrigin("*")
@Controller
public class SongController {
@Autowired
SongService ss;
	@PostMapping("/addSong")
	//response body is use to the return value is send the front end part
	@ResponseBody
	public String addSong(@RequestBody SongData songdata ) {
		
		String name=songdata.getName();
		String artist=songdata.getArtist();
		String genre=songdata.getGenre() ;
		String link=songdata.getLink();
		boolean songStatus=ss.songExist(name);
		if(songStatus==false) {
			Song song=new Song();
			song.setName(name);
			song.setArtist(artist);
			song.setGenre(genre);
			song.setLink(link);
			ss.addSong(song);
			return "success";
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
