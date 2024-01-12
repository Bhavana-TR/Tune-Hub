package com.example.spring.services;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entities.Users;
import com.example.spring.repositories.UsersRepositories;

@Service
public class UsersServiceImplementation implements UsersServices
{   
	@Autowired
    UsersRepositories repo;
	
	public String addusers( Users user)
	{
		repo.save(user);
		return "user added successfully";
		
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null)
		{
			return false;
			
		}
		else
		{
		return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user=repo.findByEmail(email);
		String db_pass = user.getPassword();
		if(password.equals(db_pass))
		{
			return true;
		}
		else
		{
		return false;
	}
}

	@Override
	public String getRole(String email) {
		Users user = repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
	}
}
