package com.web.FajneAuto.domain.repository;

import java.util.List;
import com.web.FajneAuto.domain.User;

public interface IUserDAO 
{
	List<User> ReadList(String ROLE);
	User ReadByID(int ID);
	User ReadByName(String Login);
	void UpdateData(User U);
	void UpdatePassword(User U);
	void Create(User U);
	void Delete(int ID);

}
