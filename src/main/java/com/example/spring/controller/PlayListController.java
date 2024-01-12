package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring.entities.Playlist;
import com.example.spring.entities.Song;
import com.example.spring.services.PlayListService;
import com.example.spring.services.SongService;



@Controller
public class PlayListController
{
	@Autowired
	SongService songService;
	
	@Autowired
	PlayListService playlistservice;
	
   @GetMapping("/createPlaylist")
   public String createPlaylist(Model model)
   {
	   List<Song> songList = songService.fetchAllSongs();
	   model.addAttribute("songs", songList);
	   return "createPlaylist";
   }
   
   @PostMapping("/addPlaylist")
   public String addPlaylist(@ModelAttribute Playlist playlist)
   {
	   //updating playlist table 
	   playlistservice.addPlaylist(playlist);
	   System.out.println(playlist);
	   
	   //updating song table 
	   List<Song> songList=playlist.getSongs();
	   for(Song s:songList)
	   {
		   s.getPlaylists().add(playlist);
		   songService.updateSong(s);
	   }
	   return "adminHome";
   }
   
   @GetMapping("/viewPlaylists")
   public String viewPlaylists(Model model)
   {
	   List<Playlist> allplaylists = playlistservice.fetchAllPlaylists();
	   model.addAttribute("allplaylists",allplaylists);
	   return "displayPlaylists";
   }
}
