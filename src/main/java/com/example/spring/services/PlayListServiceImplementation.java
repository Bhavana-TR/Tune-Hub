package com.example.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entities.Playlist;
import com.example.spring.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService
{
 
	@Autowired
	PlayListRepository repo;
	
	@Override
	public void addPlaylist(Playlist playlist)
	{
		repo.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		
		return repo.findAll();
	}
	
}
