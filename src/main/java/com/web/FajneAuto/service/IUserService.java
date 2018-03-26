package com.web.FajneAuto.service;

import java.util.List;

import com.web.FajneAuto.domain.User;

public interface IUserService 
{
	public List<User> ShowAll(String Role);
	public User ShowByID(int ID);
	public User ShowByLogin(String Login);
	public void Remove(int ID);
	public boolean Register(User U);
	public void UpdateData(User U);
	public void UpdatePassword(User U);
}