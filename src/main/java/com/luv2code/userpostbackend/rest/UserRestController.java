package com.luv2code.userpostbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luv2code.userpostbackend.entity.Token;
import com.luv2code.userpostbackend.entity.User;
import com.luv2code.userpostbackend.service.UserService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/Users")
public class UserRestController {

	private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService)
	{
		this.userService=userService;
	}
	
	
	@PostMapping("/signup")
	public User signup(@Valid @RequestBody  User user)
	{
		return userService.createUser(user);
	}
	
	@PostMapping("/login")
	public Token login(@Valid @RequestBody User user)
	{
		return userService.userLogin(user);
	}
}
