package com.ddu_gky.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddu_gky.model.Login;
import com.ddu_gky.model.Mark;
import com.ddu_gky.model.Register;
import com.ddu_gky.model.User;
import com.ddu_gky.service.UserService;
@Controller
public class RegisterController {

	@Autowired
	public UserService userService;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("home");
		return mv;
		
	}
	@RequestMapping("login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	@RequestMapping("stab")
	public ModelAndView register()
	{
		ModelAndView mv=new ModelAndView("stab");
		return mv;
	}
	@RequestMapping(value="studentprocess",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response,Register register)
	{
		String s=request.getParameter("stid");
		ModelAndView mv=null;
		Register register1=userService.validateStudent(register);
		if(null!=register1)
		{
			ArrayList<Mark> m=userService.All(s);
			
			mv=new ModelAndView("student");
			
			mv.addObject("mdetails",m);
		}
		else
		{
			mv=new ModelAndView("stab");
			mv.addObject("message","Invalid student id or passcode");
		}
		return mv;
	}
	
@RequestMapping(value="loginprocess",method=RequestMethod.POST)
public ModelAndView login(HttpServletRequest request,HttpServletResponse response,Login login)
{
	ModelAndView mv=null;
	User user=userService.validateUser(login);
	if(null!=user)
	{
		mv=new ModelAndView("welcome");
		mv.addObject("firstname",user.getFirstname());
	}
	else
	{
		mv=new ModelAndView("login");
	mv.addObject("message","Invalid username or password");
	}
return mv;
}

@RequestMapping(value="uploadprocess",method=RequestMethod.POST)
public ModelAndView adduser(HttpServletRequest request,HttpServletResponse response,Mark mark)
{
	userService.student(mark);
	return new ModelAndView("welcome");
}
}
