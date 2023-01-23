package com.sweetmart.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweetmart.model.User;
import com.sweetmart.service.UserService;

@RestController
@RequestMapping("/userservice")
public class UserController {

	@Autowired
    private UserService uservice;
	
	@PostMapping("/reg")
	public ResponseEntity<User> registerUserCon(@Valid @RequestBody User user) {
		User u = uservice.registerUser(user);
		
		return new ResponseEntity<>(u,HttpStatus.ACCEPTED);

	}

	@PutMapping("/update/{key}")
	public ResponseEntity<User> updateuserCon(@Valid @RequestBody User user,@PathVariable String key) {
		User u = uservice.updateuser(user, key);
		
		return new ResponseEntity<>(u,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{uid}/{key}")
	public ResponseEntity<User> deleteUserCon(@PathVariable Integer uid,@PathVariable String key) {
		User u = uservice.deleteUser(uid, key);
		
		return new ResponseEntity<>(u,HttpStatus.OK);
	}

	@GetMapping("/users/{key}")
	public ResponseEntity<List<User>> getAllUserCon(@PathVariable String key){
		List<User> list = uservice.getAllUser(key);
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
}
