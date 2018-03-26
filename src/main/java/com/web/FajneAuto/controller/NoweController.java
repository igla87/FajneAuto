package com.web.FajneAuto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/nowe")
@Controller
public class NoweController 
{
	@RequestMapping()
	public String nowe(Model model) 
	{
		return "nowe";
	}
	
	@RequestMapping("/konfigurator")
	public String konfigurator(Model model) 
	{
		return "konfigurator";
	}
}