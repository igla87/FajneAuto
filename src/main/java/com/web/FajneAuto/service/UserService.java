package com.web.FajneAuto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.web.FajneAuto.domain.User;
import com.web.FajneAuto.domain.repository.IUserDAO;


@Service
public class UserService implements IUserService
{
	@Autowired
	private IUserDAO userDAO;

	public List<User> ShowAll(String R) 
	{
		return userDAO.ReadList(R);
	}

	public User ShowByID(int ID) 
	{
		return userDAO.ReadByID(ID);
	}
	
	public User ShowByLogin(String Login) 
	{
		return userDAO.ReadByName(Login);
	}

	public void Remove(int ID) 
	{
		
		
	}

	public boolean Register(User U) 
	{
		List<User> listOfUsers = new ArrayList<>();
		
		listOfUsers = ShowAll("CUSTOMER");
		
		for(User user: listOfUsers)
		{
			if(user.getLogin() == U.getLogin() || user.getEmail() == U.getEmail())
			{
				return false;
			}
		}
		if(U.getEmail() == null || U.getLogin() == null || U.getPassword() == null)
		{
			return false;
		}
		
		if(U.getPassword().equals(U.getPassword2()))
		{
			userDAO.Create(U);
			return true;
		}
		else
		{
			return false;
		}
	}

	public void UpdateData(User U) 
	{
		userDAO.UpdateData(U);
		
	}

	public void UpdatePassword(User U) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String login = auth.getName();
	    User currentUser = ShowByLogin(login);
	    
		if(U.getPassword_old().equals(currentUser.getPassword()))
		{
			if(U.getPassword().equals(U.getPassword2()))
			{
				U.setId(currentUser.getId());
				userDAO.UpdatePassword(U);
			}
		}		
	}

	
}
