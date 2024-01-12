package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.entities.Users;
import com.example.spring.services.UsersServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController 
{       
	    @Autowired
	    UsersServices service;
	    
	    @PostMapping("/register")
        public String addusers(@ModelAttribute Users user)
        {
	    	boolean userStatus = service.emailExists(user.getEmail());
	    	if(userStatus == false)
	    	{
	    		service.addusers(user);
	    		System.out.println("user added");
	    	}
	    	else
	    	{
	    		System.out.println("user alreday exists");
	    		
	    	}
	    	return "home";
        }
	    	
	        	
	    	@PostMapping("/validate")
	    	public String validate(@RequestParam("email") String email, @RequestParam("password") String password , HttpSession session) {
	    		if(service.validateUser(email, password)==true)
	    		{
	    			String role = service.getRole(email);
	    			session.setAttribute("email",email);
	    			if(role.equals("Admin"))
	    			{
	    			return "adminHome";
	    			}
	    			else
	    			{
	    				return "customerHome";
	    			}
	    		}
	    		else
	    		{
	    			return "login";
	    		}	
        }
	    	
	    	
	    	@GetMapping("/logout")
	    	public String logout(HttpSession session)
	    	{
	    		session.invalidate();
	    		return"login";
	    	}
	    	
	    	
}
