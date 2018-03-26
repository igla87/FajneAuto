package com.web.FajneAuto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.FajneAuto.domain.User;
import com.web.FajneAuto.service.IUserService;

@RequestMapping("/")
@Controller
public class IndexController 
{
	@RequestMapping()
	public String index(Model model) 
	{
		return "index";
	}
	
	/*@Autowired
	private IUserService user; 
	
	@RequestMapping("")
	public String index(Model model) 
	{	
		List<User> list = new ArrayList<User>();
		list = user.ShowAll("CUSTOMER");
		
		model.addAttribute("temp", list);
		//model.addAttribute("temp", user.ShowByID(2));
		
		return "temp";
	}*/
}