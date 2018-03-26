package com.web.FajneAuto.domain.repository;

import java.util.List;

import com.web.FajneAuto.domain.RentalPeriod;

public interface IRentalPeriodDAO 
{
	List<RentalPeriod> ReadList();
	RentalPeriod Read(int ID);
	void Update(RentalPeriod R);
	void Create(RentalPeriod R);
	void Delete(int ID);

}
