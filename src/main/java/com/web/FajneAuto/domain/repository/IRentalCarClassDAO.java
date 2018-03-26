package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.RentalCarClass;

public interface IRentalCarClassDAO 
{
	List<RentalCarClass> ReadList();
	RentalCarClass Read(int ID);
	void Update(RentalCarClass R);
	void Create(RentalCarClass R);
	void Delete(int ID);
}
