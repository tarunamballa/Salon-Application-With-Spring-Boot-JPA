package com.salon.service;

import com.salon.bean.User;

public interface IUserService 
{
	User createUser(User u);
	User signIn(int userId,String password)throws Exception;
	User ChangeUserpassword(int userId,String password,String newpassword)throws Exception;
	User SignOut(int userId)throws Exception;

}
