package com.web.FajneAuto.domain;

public class ConfigColor 
{
	public ConfigColor()
	{
		super();
	}
	
	private int idColor;
	private String colorName;
	private int IDColorType;
	private String code;
	
	public int getIdColor() {
		return idColor;
	}
	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public int getIDColorType() {
		return IDColorType;
	}
	public void setIDColorType(int iDColorType) {
		IDColorType = iDColorType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
