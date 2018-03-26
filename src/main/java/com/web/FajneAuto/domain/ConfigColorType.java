package com.web.FajneAuto.domain;

public class ConfigColorType 
{
	public ConfigColorType ()
	{
		super();
	}
	
	private int idColorType;
	private String typeName;
	private float price;
	
	public int getIdColorType() {
		return idColorType;
	}
	public void setIdColorType(int idColorType) {
		this.idColorType = idColorType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
