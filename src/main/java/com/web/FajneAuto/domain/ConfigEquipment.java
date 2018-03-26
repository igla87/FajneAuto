package com.web.FajneAuto.domain;

public class ConfigEquipment 
{
	public ConfigEquipment()
	{
		super();
	}
	
	private int idEquipment;
	private String name;
	private String description;
	private float price;
	private String code;
	
	public int getIdEquipment() {
		return idEquipment;
	}
	public void setIdEquipment(int idEquipment) {
		this.idEquipment = idEquipment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
