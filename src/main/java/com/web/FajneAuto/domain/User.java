package com.web.FajneAuto.domain;

public class User 
{
	public User()
	{
		super();
	}
	
	private int id;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String addressCity;
	private String addressPostCode;
	private String addressStreet;
	private String login;
	private String password;
	private String password2;
	private String password_old;
	private String role;
		
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getSurname() 
	{
		return surname;
	}

	public void setSurname(String surname) 
	{
		this.surname = surname;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getAddressCity() 
	{
		return addressCity;
	}

	public void setAddressCity(String addressCity) 
	{
		this.addressCity = addressCity;
	}

	public String getAddressPostCode() 
	{
		return addressPostCode;
	}

	public void setAddressPostCode(String addressPostCode) 
	{
		this.addressPostCode = addressPostCode;
	}

	public String getAddressStreet() 
	{
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) 
	{
		this.addressStreet = addressStreet;
	}

	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login) 
	{
		this.login = login;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}

	public String getPassword2() 
	{
		return password2;
	}

	public void setPassword2(String password2) 
	{
		this.password2 = password2;
	}

	public String getPassword_old() {
		return password_old;
	}

	public void setPassword_old(String password_old) {
		this.password_old = password_old;
	}

	
	
}