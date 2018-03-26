package com.web.FajneAuto.domain;

public class ConfigEngine 
{
	public ConfigEngine()
	{
		super();
	}

	private int idEngine;
	private String designation;
	private String fuelType;
	private int capacity;
	private int hp;
	private float acceleration;
	private float combustion;
	private int emission;
	private float price;
	private String code;
	
	public int getIdEngine() {
		return idEngine;
	}
	public void setIdEngine(int idEngine) {
		this.idEngine = idEngine;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public float getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}
	public float getCombustion() {
		return combustion;
	}
	public void setCombustion(float combustion) {
		this.combustion = combustion;
	}
	public int getEmission() {
		return emission;
	}
	public void setEmission(int emission) {
		this.emission = emission;
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
