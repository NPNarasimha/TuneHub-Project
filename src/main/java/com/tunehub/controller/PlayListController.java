package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.PlayList;
import com.tunehub.entity.Song;
import com.tunehub.service.PlayListService;
import com.tunehub.service.SongService;


@Controller
public class PlayListController {
@Autowired
PlayListService ps;
@Autowired
SongService ss;
@GetMapping("/createPlaylist")
public String createPlaylist(Model model) {
	List<Song> songlist=ss.fetchAllSongs();
	model.addAttribute("songs", songlist);
    return "createPlaylist";
}

@PostMapping("/addPlaylist")
public String addPlaylist(@ModelAttribute PlayList playlist) {
	ps.addPlaylist(playlist);
	//update song table
	List<Song> songList=playlist.getSongs();
	for(Song s:songList) {
		s.getPlaylist().add(playlist);
		//update song objects in db
		ss.updateSong(s);
	}
    return "adminHome";
}
@GetMapping("/viewPlaylist")
public String viewPlaylist(Model model) {
	List<PlayList>allPlaylist=ps.fetchAllPlaylist();
	model.addAttribute("allPlaylist", allPlaylist);
    return "displayPlaylist";
}

}