package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.ConfigModel;

public interface IConfigModelDAO 
{
	List<ConfigModel> ReadList();
	ConfigModel Read(int ID);
	void Update(ConfigModel C);
	void Create(ConfigModel C);
	void Delete(int ID);

}
