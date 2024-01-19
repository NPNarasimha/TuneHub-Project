package com.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.PlayList;
import com.tunehub.repository.PlaylistRepository;

@Service
public class PlayListServiceImplemtation implements PlayListService{
	@Autowired
	PlaylistRepository pr;

	@Override
	public void addPlaylist(PlayList playlist) {
		pr.save(playlist);
		
	}

	@Override
	public List<PlayList> fetchAllPlaylist() {
		return pr.findAll();
	}
	
	

}
