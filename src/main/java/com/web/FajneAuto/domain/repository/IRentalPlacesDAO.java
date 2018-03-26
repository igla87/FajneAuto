package com.web.FajneAuto.domain.repository;

import java.util.List;

import com.web.FajneAuto.domain.RentalPlaces;

public interface IRentalPlacesDAO 
{
	List<RentalPlaces> ReadList();
	RentalPlaces Read(int ID);
	void Update(RentalPlaces R);
	void Create(RentalPlaces R);
	void Delete(int ID);

}
