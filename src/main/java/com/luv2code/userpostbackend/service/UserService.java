package com.luv2code.userpostbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.userpostbackend.dao.UserRepository;
import com.luv2code.userpostbackend.entity.Token;
import com.luv2code.userpostbackend.entity.User;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}
	
	public User createUser(User user) 
	{
		//Before creating the user, make sure email does not exists. Email is unique key in database
		Optional<User> op =userRepository.findById(user.getEmail());
		if(op.isPresent())
		{
			throw new RuntimeException("User already exists. Email - " + user.getEmail());
		}
		return userRepository.save(user);
	}
	
	public Token userLogin(User user)
	{
		Optional<User> op = userRepository.findById(user.getEmail());
		if(op.isEmpty())
		{
			throw new RuntimeException("Authentication Failed. Email not found - " + user.getEmail());
		}
		User theUser = (User)op.get();
		if(!theUser.getPassword().equals(user.getPassword()))
		{
			throw new RuntimeException("Invalid authentication credentials");
		}
		Token token = new Token();
		token.setToken("yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImNhdEBkb2cuY29tIiwidXNlcklkIjoiNjRjYWM2NmRmYTYwN2Q1M2FhNTU0NjQ0IiwiaWF0IjoxNjkxMDc3NjI3LCJleHAiOjE2OTEwODEyMjd9.mzLESGWHOda2Kzv42K5lXK7_V4VfgsdCTXCoYZbiCIE");
		token.setUserId(theUser.getEmail());
		token.setExpiresIn("3600");
		return token;
		
	}
	
	public User getUserById(String email)
	{
		Optional<User> op = userRepository.findById(email);
		if(op.isEmpty())
		{
			throw new RuntimeException("User not found. Id - " + email);
		}
		User user = (User)op.get();
		return user;
	}

}
