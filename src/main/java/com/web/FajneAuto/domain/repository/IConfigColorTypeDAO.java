package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.ConfigColorType;

public interface IConfigColorTypeDAO 
{
	List<ConfigColorType> ReadList();
	ConfigColorType Read(int ID);
	void Update(ConfigColorType C);
	void Create(ConfigColorType C);
	void Delete(int ID);

}
