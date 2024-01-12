package com.example.spring.services;

import java.util.List;

import com.example.spring.entities.Playlist;

public interface PlayListService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists(); 
			

}
