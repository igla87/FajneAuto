package com.web.FajneAuto.domain;

public class ConfigModel 
{
	public ConfigModel()
	{
		super();
	}
	
	private int idModel;
	private String name;
	private float basicPrice;
	private float standardPrice;
	private float premiumPrice;
	private String code;
	
	public int getIdModel() {
		return idModel;
	}
	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(float basicPrice) {
		this.basicPrice = basicPrice;
	}
	public float getStandardPrice() {
		return standardPrice;
	}
	public void setStandardPrice(float standardPrice) {
		this.standardPrice = standardPrice;
	}
	public float getPremiumPrice() {
		return premiumPrice;
	}
	public void setPremiumPrice(float premiumPrice) {
		this.premiumPrice = premiumPrice;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
