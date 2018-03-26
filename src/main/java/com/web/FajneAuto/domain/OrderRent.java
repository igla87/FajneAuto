package com.web.FajneAuto.domain;

import java.util.Calendar;
import java.util.Date;

public class OrderRent extends Order
{
	private int idCar;
	private Date startDate;
	private Date endDate;
	private int startPlaceID;
	private int endPlaceID;
	
	private int startHours;
	private int startMinutes;
	private Date startDay;
	private int endHours;
	private int endMinutes;
	private Date endDay;
	
	public OrderRent()
	{
		startHours = endHours = 6;
		startMinutes = endMinutes = 0;
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		startDay = c.getTime();
		
		c.add(Calendar.DATE, 3);
		endDay = c.getTime();
	}
	
	public int getIdCar() 
	{
		return idCar;
	}
	
	public void setIdCar(int idCar) 
	{
		this.idCar = idCar;
	}
	
	public Date getStartDate() 
	{
		return startDate;
	}
	
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}
	
	public Date getEndDate() 
	{
		return endDate;
	}
	
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}
	
	public int getStartPlaceID() 
	{
		return startPlaceID;
	}
	
	public void setStartPlaceID(int startPlaceID) 
	{
		this.startPlaceID = startPlaceID;
	}
	
	public int getEndPlaceID() 
	{
		return endPlaceID;
	}
	
	public void setEndPlaceID(int endPlaceID) 
	{
		this.endPlaceID = endPlaceID;
	}

	public int getStartHours() {
		return startHours;
	}

	public void setStartHours(int startHours) {
		this.startHours = startHours;
	}

	public int getStartMinutes() {
		return startMinutes;
	}

	public void setStartMinutes(int startMinutes) {
		this.startMinutes = startMinutes;
	}

	public int getEndHours() {
		return endHours;
	}

	public void setEndHours(int endHours) {
		this.endHours = endHours;
	}

	public int getEndMinutes() {
		return endMinutes;
	}

	public void setEndMinutes(int endMinutes) {
		this.endMinutes = endMinutes;
	}
	public Date getStartDay() 
	{
		return startDay;
	}

	public void setStartDay(Date startDay) 
	{
		this.startDay = startDay;
	}

	public Date getEndDay() 
	{
		return endDay;
	}

	public void setEndDay(Date endDay) 
	{
		this.endDay = endDay;
	}
	
	//Sklejanie startDate i endDate z startHours, startMinutes, startDay etc.	
	public void setStartDate()
	{
		Calendar temp = Calendar.getInstance();
		
		temp.setTime(startDay);
		temp.set(Calendar.HOUR, startHours);
		temp.set(Calendar.MINUTE, startMinutes);
		
		startDate = temp.getTime();
	}
	
	public void setEndDate()
	{
		Calendar temp = Calendar.getInstance();
		
		temp.setTime(endDay);
		temp.set(Calendar.HOUR, endHours);
		temp.set(Calendar.MINUTE, endMinutes);
		
		endDate = temp.getTime();
	}


}
