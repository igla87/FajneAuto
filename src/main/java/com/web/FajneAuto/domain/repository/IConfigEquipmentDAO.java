package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.ConfigEquipment;

public interface IConfigEquipmentDAO 
{
	List<ConfigEquipment> ReadList();
	ConfigEquipment Read(int ID);
	void Update(ConfigEquipment C);
	void Create(ConfigEquipment C);
	void Delete(int ID);

}
