package com.web.FajneAuto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.FajneAuto.domain.RentalCarClass;
import com.web.FajneAuto.domain.RentalPeriod;
import com.web.FajneAuto.domain.RentalPlaces;
import com.web.FajneAuto.domain.repository.IRentalCarClassDAO;
import com.web.FajneAuto.domain.repository.IRentalPeriodDAO;
import com.web.FajneAuto.domain.repository.IRentalPlacesDAO;


@Service
public class RentalOptionService implements IRentalOptionService
{
	@Autowired
	private IRentalPlacesDAO placeDAO;
	@Autowired
	private IRentalCarClassDAO classDAO;
	@Autowired
	private IRentalPeriodDAO periodDAO;

	public List<RentalPlaces> ShowRentalPlacesList() 
	{
		return placeDAO.ReadList(); 
	}

	public RentalPlaces ShowRentalPlacesDetails(int ID) 
	{
		return placeDAO.Read(ID);
	}

	public void RemoveRentalPlace(int ID) 
	{
		placeDAO.Delete(ID);
	}

	public void AddRentalPlace(RentalPlaces R) 
	{
		placeDAO.Create(R);
	}

	public void UpdateRentalPlace(RentalPlaces R) 
	{
		placeDAO.Update(R);
	}


	public List<RentalCarClass> ShowRentalCarClassList() 
	{
		return classDAO.ReadList();
	}

	public RentalCarClass ShowRentalCarClassDetails(int ID) 
	{
		return classDAO.Read(ID);
	}

	public void RemoveRentalCarClass(int ID) 
	{
		classDAO.Delete(ID);
	}

	public void AddRentalCarClass(RentalCarClass R) 
	{
		classDAO.Create(R);
	}

	public void UpdateRentalCarClass(RentalCarClass R) 
	{
		classDAO.Update(R);
	}


	public List<RentalPeriod> ShowRentalPeriodList() 
	{
		return periodDAO.ReadList();
	}

	public RentalPeriod ShowRentalPeriodDetails(int ID) 
	{
		return periodDAO.Read(ID);
	}

	public void RemoveRentalPeriod(int ID) 
	{
		periodDAO.Delete(ID);
	}

	public void AddRentalPeriod(RentalPeriod R) 
	{
		boolean error = false;
		List<RentalPeriod> list = new ArrayList<>();
		list = periodDAO.ReadList();
		
		if(R.getDaysMin() > R.getDaysMax())
		{
			error = true;
		}
		
		for (RentalPeriod period: list)
		{
			if(period.getDaysMin() >= R.getDaysMin() && period.getDaysMin() <= R.getDaysMax())
			{
				error = true;
			}
			if(period.getDaysMax() >= R.getDaysMin() && period.getDaysMax() <= R.getDaysMax())
			{
				error = true;
			}
		}
		
		if(error == false)
		{
			periodDAO.Create(R);			
		}
	}

	public void UpdateRentalPeriod(RentalPeriod R) 
	{
		boolean error = false;
		List<RentalPeriod> list = new ArrayList<>();
		list = periodDAO.ReadList();
		
		if(R.getDaysMin() > R.getDaysMax())
		{
			error = true;
		}
		
		for (RentalPeriod period: list)
		{
			if(period.getDaysMin() >= R.getDaysMin() && period.getDaysMin() <= R.getDaysMax())
			{
				error = true;
			}
			if(period.getDaysMax() >= R.getDaysMin() && period.getDaysMax() <= R.getDaysMax())
			{
				error = true;
			}
		}
		
		if(error == false)
		{
			periodDAO.Update(R);			
		}	
	}	
}
