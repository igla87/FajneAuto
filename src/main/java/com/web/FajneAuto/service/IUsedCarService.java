package com.web.FajneAuto.service;

import java.util.List;

import com.web.FajneAuto.domain.UsedCar;

public interface IUsedCarService 
{
	public List<UsedCar> ShowAll();
	public UsedCar ShowByID(int ID);
	public void Remove(int ID);
	public void Add(UsedCar U);
	public void Update(UsedCar U);
}