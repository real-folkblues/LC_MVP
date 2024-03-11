package com.example.LC_MVP.controllers;

import com.example.LC_MVP.dto.LoginDto;
import com.example.LC_MVP.dto.UserRegistrationDto;
import com.example.LC_MVP.models.User;
import com.example.LC_MVP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController ( UserService userService ) {
		this.userService = userService;
	}

	@PostMapping ("/register")
	public ResponseEntity <User> registerUser ( @RequestBody UserRegistrationDto registrationDto ) {
		try {
			User newUser = userService.registerUser (registrationDto.getUsername (), registrationDto.getPassword ());
			// Omit the password in the response for security reasons
			newUser.setPassword (null);
			return new ResponseEntity <> (newUser, HttpStatus.CREATED);
		} catch (IllegalStateException e) {
			// Handle the case where username is already in use
			return new ResponseEntity <> (null, HttpStatus.BAD_REQUEST);
		}
	}

	// In UserController.java

	@PostMapping ("/login")
	public ResponseEntity <User> loginUser ( @RequestBody LoginDto loginDto ) {
		try {
			User authenticatedUser = userService.loginUser (loginDto.getUsername (), loginDto.getPassword ());
			// Omit the password in the response for security
			authenticatedUser.setPassword (null);
			return new ResponseEntity <> (authenticatedUser, HttpStatus.OK);
		} catch (IllegalStateException e) {
			// Handle invalid credentials
			return new ResponseEntity <> (null, HttpStatus.UNAUTHORIZED);
		}
	}

	// Additional endpoints like login, delete, update, etc., can be implemented as needed
}
