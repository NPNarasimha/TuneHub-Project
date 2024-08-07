package com.tunehub.entity;

import java.util.List;

import jakarta.persistence.ManyToMany;

public class SongData {
	String name;
	String artist;
	String genre;
	String link;
	@ManyToMany
	List<PlayList>playlist;
	public SongData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SongData(String name, String artist, String genre, String link, List<PlayList> playlist) {
		super();
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.playlist = playlist;
	}
	@Override
	public String toString() {
		return "SongData [name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link + ", playlist="
				+ playlist + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<PlayList> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(List<PlayList> playlist) {
		this.playlist = playlist;
	}
	
	
	
}