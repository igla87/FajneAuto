package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.ConfigEngine;

public interface IConfigEngineDAO 
{
	List<ConfigEngine> ReadList();
	ConfigEngine Read(int ID);
	void Update(ConfigEngine C);
	void Create(ConfigEngine C);
	void Delete(int ID);

}
