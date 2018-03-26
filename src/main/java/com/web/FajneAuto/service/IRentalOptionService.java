package com.web.FajneAuto.service;

import java.util.List;

import com.web.FajneAuto.domain.RentalCarClass;
import com.web.FajneAuto.domain.RentalPeriod;
import com.web.FajneAuto.domain.RentalPlaces;

public interface IRentalOptionService 
{
	public List<RentalPlaces> ShowRentalPlacesList();
	public RentalPlaces ShowRentalPlacesDetails(int ID);
	public void RemoveRentalPlace(int ID);
	public void AddRentalPlace(RentalPlaces R);
	public void UpdateRentalPlace(RentalPlaces R);
	
	public List<RentalCarClass> ShowRentalCarClassList();
	public RentalCarClass ShowRentalCarClassDetails(int ID);
	public void RemoveRentalCarClass(int ID);
	public void AddRentalCarClass(RentalCarClass R);
	public void UpdateRentalCarClass(RentalCarClass R);
	
	public List<RentalPeriod> ShowRentalPeriodList();
	public RentalPeriod ShowRentalPeriodDetails(int ID);
	public void RemoveRentalPeriod(int ID);
	public void AddRentalPeriod(RentalPeriod R);
	public void UpdateRentalPeriod(RentalPeriod R);
}
