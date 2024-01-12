package com.example.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.entities.Users;

public interface UsersRepositories extends JpaRepository<Users , Integer>
{
     public Users findByEmail(String email);
}