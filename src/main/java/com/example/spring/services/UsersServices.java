package com.example.spring.services;

import com.example.spring.entities.Users;

public interface UsersServices 
{
	
    public String addusers(Users user);
    public boolean emailExists(String email);
    public boolean validateUser(String email, String password);
    public String getRole(String email);
    public Users getUser(String email);
    public void updateUser(Users user);
    
}
