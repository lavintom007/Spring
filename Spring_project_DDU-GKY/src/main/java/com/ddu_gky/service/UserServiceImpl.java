package com.ddu_gky.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddu_gky.dao.UserDao;
import com.ddu_gky.model.Login;
import com.ddu_gky.model.Mark;
import com.ddu_gky.model.Register;
import com.ddu_gky.model.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao userDao;
	
	public void register(User user)
	{
		userDao.register(user);
	}
	public User validateUser(Login login) 
	{
		return userDao.validateUser(login);
	}
	public void student(Mark mark) 
	{
		
		userDao.student(mark);
	}
	public Register validateStudent(Register register)
	{
		return userDao.validateStudent(register);
	}
	

 public ArrayList<Mark>  All(String s) {
		return userDao.All(s);
	}
}
