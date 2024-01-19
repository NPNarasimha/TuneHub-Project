package com.tunehub.service;

import java.util.List;

import com.tunehub.entity.Song;

public interface SongService {

	public String addSong(Song song);
	public void updateSong(Song song);
	public List<Song> fetchAllSongs();

	public Boolean songExist(String name);
	
}
