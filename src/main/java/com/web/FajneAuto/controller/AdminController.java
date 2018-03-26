package com.web.FajneAuto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.FajneAuto.domain.RentalCarClass;
import com.web.FajneAuto.domain.RentalPeriod;
import com.web.FajneAuto.domain.RentalPlaces;
import com.web.FajneAuto.service.IRentalOptionService;

@RequestMapping("/admin")
@Controller
public class AdminController 
{
	@Autowired
	private IRentalOptionService rentService;
	
	//------------------------------------
	// PANELU ADMINISTRATORA - MENU GŁÓWNE
	//------------------------------------
	@RequestMapping()
	public String adminMenu(Model model) 
	{
		return "admin";
	}
	
	//------------------------------------
	// WYNAJEM - MENU GŁÓWNE
	//------------------------------------
	@RequestMapping("/wynajem")
	public String adminRentMenu(Model model) 
	{
		return "admin/wynajem";
	}
	
	
	//------------------------------------
	// WYNAJEM - KLASY AUT
	//------------------------------------
	@RequestMapping("/wynajem/auta")
	public String adminRentCarClass(Model model) 
	{
		model.addAttribute("list", rentService.ShowRentalCarClassList());
		return "admin/wynajem/auta";
	}
	
	// WYNAJEM - KLASY AUT (edycja)
	@RequestMapping("/wynajem/auta/edytuj/{id}")
	public String adminRentCarClassEdit(Model model, @PathVariable("id") int carClassID) 
	{
		model.addAttribute("carClass", rentService.ShowRentalCarClassDetails(carClassID));
		return "admin/wynajem/auta/edytuj";
	}
	@RequestMapping(value="/wynajem/auta/edytuj/{id}", method=RequestMethod.POST)
	public String adminRentCarClassEditForm(@ModelAttribute("carClass") RentalCarClass carClassToEdit) 
	{
		rentService.UpdateRentalCarClass(carClassToEdit);
		return "redirect:/admin/wynajem/auta";
	}
	
	// WYNAJEM - KLASY AUT (usunięcie)
	@RequestMapping("/wynajem/auta/usun/{id}")
	public String adminRentCarClassDelete(Model model, @PathVariable("id") int carClassID) 
	{
		rentService.RemoveRentalCarClass(carClassID);
		return "redirect:/admin/wynajem/auta";
	}
	
	// WYNAJEM - KLASY AUT (dodanie nowej klasy auta)
	@RequestMapping("/wynajem/auta/dodaj")
	public String adminRentCarClassAdd(Model model) 
	{
		RentalCarClass newCarClass = new RentalCarClass();
		model.addAttribute("carClass", newCarClass);
		return "admin/wynajem/auta/dodaj";
	}
	@RequestMapping(value="/wynajem/auta/dodaj", method=RequestMethod.POST)
	public String adminRentCarClassAddForm(@ModelAttribute("carClass") RentalCarClass carClassToAdd) 
	{
		rentService.AddRentalCarClass(carClassToAdd);;
		return "redirect:/admin/wynajem/auta";
	}
	
	//------------------------------------
	// WYNAJEM - MIEJSCA ODBIORU
	//------------------------------------
	@RequestMapping("/wynajem/miejsca")
	public String adminRentPlaces(Model model) 
	{
		model.addAttribute("list", rentService.ShowRentalPlacesList());
		return "admin/wynajem/miejsca";
	}
	
	// WYNAJEM - KLASY AUT (edycja)
	@RequestMapping("/wynajem/miejsca/edytuj/{id}")
	public String adminRentPlacesEdit(Model model, @PathVariable("id") int placeID) 
	{
		model.addAttribute("place", rentService.ShowRentalPlacesDetails(placeID));
		return "admin/wynajem/miejsca/edytuj";
	}
	@RequestMapping(value="/wynajem/miejsca/edytuj/{id}", method=RequestMethod.POST)
	public String adminRentPlacesEditForm(@ModelAttribute("place") RentalPlaces  placeToEdit) 
	{
		rentService.UpdateRentalPlace(placeToEdit);
		return "redirect:/admin/wynajem/miejsca";
	}
	
	// WYNAJEM - KLASY AUT (usunięcie)
	@RequestMapping("/wynajem/miejsca/usun/{id}")
	public String adminRentPlacesDelete(Model model, @PathVariable("id") int placeID) 
	{
		rentService.RemoveRentalPlace(placeID);
		return "redirect:/admin/wynajem/miejsca";
	}
	
	// WYNAJEM - KLASY AUT (dodanie nowej klasy auta)
	@RequestMapping("/wynajem/miejsca/dodaj")
	public String adminRentPlacesAdd(Model model) 
	{
		RentalPlaces newPlace = new RentalPlaces();
		model.addAttribute("place", newPlace);
		return "admin/wynajem/miejsca/dodaj";
	}
	@RequestMapping(value="/wynajem/miejsca/dodaj", method=RequestMethod.POST)
	public String adminRentPlacesAddForm(@ModelAttribute("place") RentalPlaces placeToAdd) 
	{
		rentService.AddRentalPlace(placeToAdd);;
		return "redirect:/admin/wynajem/miejsca";
	}
	
	
	//------------------------------------
	// WYNAJEM - OKRESY WYNAJMU
	//------------------------------------
	@RequestMapping("/wynajem/okresy_wynajmu")
	public String adminRentPeriod(Model model) 
	{
		model.addAttribute("list", rentService.ShowRentalPeriodList());
		return "admin/wynajem/okresy_wynajmu";
	}
	
	// WYNAJEM - KLASY AUT (edycja)
	@RequestMapping("/wynajem/okresy_wynajmu/edytuj/{id}")
	public String adminRentPeriodEdit(Model model, @PathVariable("id") int periodID) 
	{
		model.addAttribute("period", rentService.ShowRentalPeriodDetails(periodID));
		return "admin/wynajem/okresy_wynajmu/edytuj";
	}
	@RequestMapping(value="/wynajem/okresy_wynajmu/edytuj/{id}", method=RequestMethod.POST)
	public String adminRentPeriodEditForm(@ModelAttribute("period") RentalPeriod periodToEdit) 
	{
		rentService.UpdateRentalPeriod(periodToEdit);
		return "redirect:/admin/wynajem/okresy_wynajmu";
	}
	
	// WYNAJEM - KLASY AUT (usunięcie)
	@RequestMapping("/wynajem/okresy_wynajmu/usun/{id}")
	public String adminRentPeriodDelete(Model model, @PathVariable("id") int periodID) 
	{
		rentService.RemoveRentalPeriod(periodID);
		return "redirect:/admin/wynajem/okresy_wynajmu";
	}
	
	// WYNAJEM - KLASY AUT (dodanie nowej klasy auta)
	@RequestMapping("/wynajem/okresy_wynajmu/dodaj")
	public String adminRentPeriodAdd(Model model) 
	{
		RentalPeriod newPeriod = new RentalPeriod();
		model.addAttribute("period", newPeriod);
		return "admin/wynajem/okresy_wynajmu/dodaj";
	}
	@RequestMapping(value="/wynajem/okresy_wynajmu/dodaj", method=RequestMethod.POST)
	public String adminRentPeriodAddForm(@ModelAttribute("period") RentalPeriod periodToAdd) 
	{
		rentService.AddRentalPeriod(periodToAdd);
		return "redirect:/admin/wynajem/okresy_wynajmu";
	}
	
	
}