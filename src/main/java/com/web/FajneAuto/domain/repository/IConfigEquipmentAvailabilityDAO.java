package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.ConfigEquipmentAvailability;

public interface IConfigEquipmentAvailabilityDAO 
{
	List<ConfigEquipmentAvailability> ReadList(int ID);
	ConfigEquipmentAvailability Read(int ID);
	void Update(ConfigEquipmentAvailability C);
	void Create(ConfigEquipmentAvailability C);
	void Delete(int ID);

}
