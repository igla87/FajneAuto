package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.ConfigColor;

public interface IConfigColorDAO 
{
	List<ConfigColor> ReadList();
	ConfigColor Read(int ID);
	void Update(ConfigColor C);
	void Create(ConfigColor C);
	void Delete(int ID);
	
}
