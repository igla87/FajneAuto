package com.web.FajneAuto.domain;

public class RentalPlaces 
{
	public RentalPlaces()
	{
		super();
	}
	
	private int idRentalPlace;
	private String name;
	private String address;
	
	public int getIdRentalPlace() {
		return idRentalPlace;
	}
	public void setIdRentalPlace(int iDRentalPlace) {
		idRentalPlace = iDRentalPlace;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
