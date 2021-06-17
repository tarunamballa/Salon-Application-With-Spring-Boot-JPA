package com.salon.service;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.bean.User;
import com.salon.dao.IUserRepository;

@Service
public class UserServiceImpl implements IUserService 
{
	
	@Autowired
	IUserRepository userrepository;
	
	@Override
	public User createUser(User u)
	{
		User u1=userrepository.save(u);
		return u1;
	}
	
	@Override
	public User signIn(int userId,String password)throws Exception 
	{
	   Supplier<Exception> s1 = ()->new ResourceNotFoundException("Invalid id & Password for SignIn");
	  User u1=((Optional<User>) userrepository.SignIn(userId,password)).orElseThrow(s1);
	   return u1;
	}
	
	@Override
	public User ChangeUserpassword(int userId,String password,String newpassword) throws Exception  
	{
		    String np=newpassword;
		    Supplier<Exception> s1 = ()->new ResourceNotFoundException("Provided Id and Password is not Valid");
		    User u1=((Optional<User>) userrepository.Changepassword(userId,password)).orElseThrow(s1);
		
		    u1.setPassword(np);
			userrepository.save(u1);
			return u1;	
	}
	
	@Override
	public User SignOut(int userIdno) throws Exception 
	{
	   Supplier<Exception> s1 = ()->new ResourceNotFoundException("Invalid id for SignOut");
	   User u1=((Optional<User>) userrepository.SignOut(userIdno)).orElseThrow(s1);
	   return u1;
	}

}
