package com.web.FajneAuto.controller;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.FajneAuto.domain.OrderRent;
import com.web.FajneAuto.domain.RentalCarClass;
import com.web.FajneAuto.domain.RentalPlaces;
import com.web.FajneAuto.domain.User;
//import com.web.FajneAuto.domain.RentOrderTemp;
//import com.web.FajneAuto.domain.RentalCarClass;
//import com.web.FajneAuto.domain.repository.IRentalCarClassDAO;
import com.web.FajneAuto.service.IOrderService;
import com.web.FajneAuto.service.IRentalOptionService;
import com.web.FajneAuto.service.IUserService;

@RequestMapping("/wynajem")
@Controller
public class WynajemController 
{
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IRentalOptionService rentService;
	
	@Autowired
	private IUserService userService;
	
	//@Autowired
	//private IRentalCarClassDAO classDAO;
	
	@RequestMapping()
	public String main(Model model) 
	{
		return "wynajem";
	}
	
	@RequestMapping("/informacje")
	public String info(Model model) 
	{
		return "informacje";
	}
	
	@RequestMapping(value="/formularz", method=RequestMethod.GET)
	public String emptyForm(Model model) 
	{
		model.addAttribute("StartPlaces", rentService.ShowRentalPlacesList());
		model.addAttribute("EndPlaces", rentService.ShowRentalPlacesList());
		model.addAttribute("CarClass", rentService.ShowRentalCarClassList());
		
		OrderRent newRentOrder = new OrderRent();
		//RentOrderTemp newRentOrder = new RentOrderTemp();
		model.addAttribute("newOrder", newRentOrder);		
		
		return "wynajem/formularz";
	}
	
	@RequestMapping(value="/formularz", method=RequestMethod.POST)
	public String formSummary(@ModelAttribute("newOrder") OrderRent newRentOrder,
							  @ModelAttribute("StartPlaces") RentalPlaces startPlace, 
							  @ModelAttribute("EndPlaces") RentalPlaces endPlace,
							  @ModelAttribute("CarClass") RentalCarClass carClass,
							  @RequestParam("startPlace") int IDstartPlace) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String login = auth.getName();
	    User user = userService.ShowByLogin(login);
		newRentOrder.setIdCustomer(user.getId());
		

		
		
		
		newRentOrder.setStartPlaceID(startPlace.getIdRentalPlace());
		newRentOrder.setEndPlaceID(endPlace.getIdRentalPlace());
		
		orderService.AddRentOrder(newRentOrder);
		
		return "wynajem";
	}
}