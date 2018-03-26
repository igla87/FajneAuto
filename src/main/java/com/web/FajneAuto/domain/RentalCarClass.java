package com.web.FajneAuto.domain;

public class RentalCarClass 
{
	public RentalCarClass()
	{
		super();
	}

	private int idRentalClass;
	private String className;
	private float pricePerDay;
	
	public int getIdRentalClass() {
		return idRentalClass;
	}
	public void setIdRentalClass(int idRentalClass) {
		this.idRentalClass = idRentalClass;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public float getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
}
