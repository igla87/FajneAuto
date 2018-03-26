package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.ConfigEngineAvailability;

public interface IConfigEngineAvailabilityDAO 
{
	List<ConfigEngineAvailability> ReadList(int ID);
	ConfigEngineAvailability Read(int ID);
	void Update(ConfigEngineAvailability C);
	void Create(ConfigEngineAvailability C);
	void Delete(int ID);
}
