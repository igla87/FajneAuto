package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.UsedCar;

public interface IUsedCarDAO 
{
	List<UsedCar> ReadList();
	UsedCar Read(int ID);
	void Update(UsedCar U);
	void Create(UsedCar U);
	void Delete(int ID);

}
