package com.web.FajneAuto.domain;

public class UsedCar 
{
	public UsedCar()
	{
		super();
	}
	
	private int idCar;
	private String brand;
	private String model;
	private String version;
	private int productionYear;
	private String color;
	private String engineDesignation;
	private String engineFuel;
	private int engineCapacity;
	private int HP;
	private String description;
	private float sellPrice;
	private int IDRentalClass;
	private boolean isAvailable;
	
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int IDCar) {
		idCar = IDCar;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String Brand) {
		this.brand = Brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String Model) {
		this.model = Model;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEngineDesignation() {
		return engineDesignation;
	}
	public void setEngineDesignation(String engineDesignation) {
		this.engineDesignation = engineDesignation;
	}
	public String getEngineFuel() {
		return engineFuel;
	}
	public void setEngineFuel(String engineFuel) {
		this.engineFuel = engineFuel;
	}
	public int getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getIDRentalClass() {
		return IDRentalClass;
	}
	public void setIDRentalClass(int iDRentalClass) {
		IDRentalClass = iDRentalClass;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
