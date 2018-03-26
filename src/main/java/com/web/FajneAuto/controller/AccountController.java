package com.web.FajneAuto.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.FajneAuto.domain.User;
import com.web.FajneAuto.service.IUserService;

@RequestMapping("/konto")
@Controller
public class AccountController 
{
	@Autowired
	private IUserService userService;
	
	//-------------------
	//   STRONA GŁÓWNA KONTA
	//-------------------
	@RequestMapping()
	public String konto() 
	{
		return "konto";
	}
	
	//-------------------
	//   LOGOWANIE
	//-------------------
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() 
	{
		return "login";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) 
	{
		return "loginfailed";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) 
	{
		return "logout";
	}
	
	//-------------------
	//   REJESTRACJA
	//-------------------
	@RequestMapping(value="/rejestracja", method=RequestMethod.GET)
	public String emptyRegisterForm(Model model) 
	{
		User customer = new User();
		model.addAttribute("newAccount", customer);
		
		return "konto/rejestracja";
	}
	
	@RequestMapping(value="/rejestracja", method=RequestMethod.POST)
	public String formSummary(@ModelAttribute("newAccount") User customerToAdd) 
	{
		if(userService.Register(customerToAdd) == true)
		{
			return "redirect:/konto/login";
		}
		else
		{
			return "konto/rejestracja";
		}
	}
	
	//-------------------
	//   WYŚWIETLENIE DANYCH ZALOGOWANEGO KLIENTA
	//-------------------
	
	@RequestMapping("/dane")
	public String daneKlienta(Model model) 
	{
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String login = auth.getName();
	     
	     model.addAttribute("currentUser", userService.ShowByLogin(login));
	     
	     return "konto/dane";
	}

	//-------------------
	//   ZMIANA DANYCH
	//-------------------	
	@RequestMapping("/dane/edytuj")
	public String edytujDaneKlienta(Model model) 
	{
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String login = auth.getName();
	     User user = userService.ShowByLogin(login);
	     model.addAttribute("currentUser", user);
	     
	     return "konto/dane/edytuj";
	}
	@RequestMapping(value="/dane/edytuj", method=RequestMethod.POST)
	public String edytujDaneKlientaForm(@ModelAttribute("currentUser") User userToEdit) 
	{
		 userService.UpdateData(userToEdit);
	     
	     return "redirect:/konto/dane";
	}
	
	//-------------------
	//   ZMIANA HASŁA
	//-------------------
	@RequestMapping("/dane/haslo")
	public String edytujHaslo(Model model) 
	{
	     User user = new User();
	     model.addAttribute("currentUser", user);
	     
	     return "konto/dane/haslo";
	}
	
	@RequestMapping(value="/dane/haslo", method=RequestMethod.POST)
	public String edytujHasloForm(@ModelAttribute("currentUser") User userToEdit)
	{
		 userService.UpdatePassword(userToEdit);
	     
	     return "redirect:/konto/dane";
	}
}
