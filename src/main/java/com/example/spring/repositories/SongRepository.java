package com.example.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entities.Song;

public interface SongRepository extends JpaRepository<Song , Integer>
{
   public Song findByName(String name);
}
