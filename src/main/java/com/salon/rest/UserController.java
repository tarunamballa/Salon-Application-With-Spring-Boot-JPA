package com.salon.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.bean.User;
import com.salon.service.UserServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController 
{
		@Autowired
		UserServiceImpl userservice;
		
		@PostMapping(path="/addUser")
		public ResponseEntity<User> addUser(@Valid @RequestBody User u)
		{
			User u1=userservice.createUser(u);
			ResponseEntity<User> re=new ResponseEntity<User>(u1,HttpStatus.OK);
			return re;
		}
		
		
	    @GetMapping("/SignIn/{userId}/{password}")
		public ResponseEntity <User> Welcome_To_SALOON_Sign_In(@RequestBody int userId,String password)throws Exception
		{
	        User u1=userservice.signIn(userId,password);
			ResponseEntity<User> re=new ResponseEntity<User>(u1,HttpStatus.OK);
			return re;
			
		}
		
		@PutMapping(path="/ChangePassword/{userId}/{password}/{newpassword}")
		public ResponseEntity<User> Want_To_Change_Password(@Valid @PathVariable int userId,String password,String newpassword) throws Exception
		{
			User u1=userservice.ChangeUserpassword(userId,password,newpassword);
			
			ResponseEntity<User> re=new ResponseEntity<User>(u1,HttpStatus.OK);
			return re;
		}
		
		@GetMapping("/SignOut/{userIdno}")
		public ResponseEntity <String> Sign_Out(@RequestBody int userId) throws Exception
		{
	        User u1= userservice.SignOut(userId);
	        String s="Logged Out Succssfully";
			ResponseEntity<String> re=new ResponseEntity<String>(s,HttpStatus.OK);
			return re;
			
		}

}

