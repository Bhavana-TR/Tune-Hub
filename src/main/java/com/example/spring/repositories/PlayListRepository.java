package com.example.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entities.Playlist;

public interface PlayListRepository extends JpaRepository<Playlist, Integer>{

}
