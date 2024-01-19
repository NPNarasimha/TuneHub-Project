package com.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Song;
import com.tunehub.repository.SongRepository;

@Service
public class SongServiceImplement implements SongService{
@Autowired
SongRepository songRepo;

@Override
public String addSong(Song song) {
	 songRepo.save(song);
	return "Song is added";
}

@Override
public List<Song> fetchAllSongs() {
	return songRepo.findAll();
}

@Override
public Boolean songExist(String name) {
	Song song=songRepo.findByName(name);
	if(song==null) {
		return false;
	}else {
		return true;
	}
}

@Override
public void updateSong(Song song) {
	songRepo.save(song);
	
}

	

}
