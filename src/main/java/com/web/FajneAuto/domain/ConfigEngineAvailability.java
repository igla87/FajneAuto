package com.web.FajneAuto.domain;

public class ConfigEngineAvailability 
{
	public ConfigEngineAvailability()
	{
		super();
	}
	
	private int idEngineAv;
	private int idModel;
	private int idEngine;
	private boolean basicVersion;
	private boolean standardVersion;
	private boolean premiumVersion;
	
	public int getIdEngineAv() {
		return idEngineAv;
	}
	public void setIdEngineAv(int idEngineAv) {
		this.idEngineAv = idEngineAv;
	}
	public int getIdModel() {
		return idModel;
	}
	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}
	public int getIdEngine() {
		return idEngine;
	}
	public void setIdEngine(int idEngine) {
		this.idEngine = idEngine;
	}
	public boolean isBasicVersion() {
		return basicVersion;
	}
	public void setBasicVersion(boolean basicVersion) {
		this.basicVersion = basicVersion;
	}
	public boolean isStandardVersion() {
		return standardVersion;
	}
	public void setStandardVersion(boolean standardVersion) {
		this.standardVersion = standardVersion;
	}
	public boolean isPremiumVersion() {
		return premiumVersion;
	}
	public void setPremiumVersion(boolean premiumVersion) {
		this.premiumVersion = premiumVersion;
	}
	
	
}
