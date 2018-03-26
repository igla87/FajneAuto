package com.web.FajneAuto.domain;

public class ConfigEquipmentAvailability 
{
	public ConfigEquipmentAvailability()
	{
		super();
	}
	
	private int idEquipmentAv;
	private int idModel;
	private int idEquipment;
	private String basicVersion;
	private String standardVersion;
	private String premiumVersion;
	
	public int getIdEquipmentAv() {
		return idEquipmentAv;
	}
	public void setIdEquipmentAv(int idEquipmentAv) {
		this.idEquipmentAv = idEquipmentAv;
	}
	public int getIdModel() {
		return idModel;
	}
	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}
	public int getIdEquipment() {
		return idEquipment;
	}
	public void setIdEquipment(int idEquipment) {
		this.idEquipment = idEquipment;
	}
	public String getBasicVersion() {
		return basicVersion;
	}
	public void setBasicVersion(String basicVersion) {
		this.basicVersion = basicVersion;
	}
	public String getStandardVersion() {
		return standardVersion;
	}
	public void setStandardVersion(String standardVersion) {
		this.standardVersion = standardVersion;
	}
	public String getPremiumVersion() {
		return premiumVersion;
	}
	public void setPremiumVersion(String premiumVersion) {
		this.premiumVersion = premiumVersion;
	}
}
