package com.ddu_gky.service;

import java.util.ArrayList;

import com.ddu_gky.model.Login;
import com.ddu_gky.model.Mark;
import com.ddu_gky.model.Register;
import com.ddu_gky.model.User;

public interface UserService {
	
	void register(User user);
	
	User validateUser(Login login);
	
	void student(Mark mark);
	
	Register validateStudent(Register register);

	ArrayList<Mark> All(String s);
}
