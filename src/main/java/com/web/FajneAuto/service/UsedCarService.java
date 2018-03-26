package com.web.FajneAuto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.FajneAuto.domain.UsedCar;
import com.web.FajneAuto.domain.repository.IUsedCarDAO;


@Service
public class UsedCarService implements IUsedCarService
{
	@Autowired
	private IUsedCarDAO usedCarDAO;

	public List<UsedCar> ShowAll() 
	{
		return usedCarDAO.ReadList();
	}

	public UsedCar ShowByID(int ID) 
	{
		return usedCarDAO.Read(ID);
	}

	public void Remove(int ID) 
	{
		
		
	}

	public void Add(UsedCar U) 
	{
		
		
	}

	public void Update(UsedCar U) 
	{
		
		
	}
	
}
