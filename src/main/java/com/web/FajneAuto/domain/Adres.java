package com.web.FajneAuto.domain;

public class Adres 
{
	private String miasto;
	private String kodPocztowy;
	private String ulica;
	private String nrDomu;
	private String nrMieszkania;
	
	public String getMiasto() 
	{
		return miasto;
	}
	public void setMiasto(String miasto) 
	{
		this.miasto = miasto;
	}
	public String getKodPocztowy() 
	{
		return kodPocztowy;
	}
	public void setKodPocztowy(String kodPocztowy) 
	{
		this.kodPocztowy = kodPocztowy;
	}
	public String getUlica() 
	{
		return ulica;
	}
	public void setUlica(String ulica) 
	{
		this.ulica = ulica;
	}
	public String getNrDomu() 
	{
		return nrDomu;
	}
	public void setNrDomu(String nrDomu) 
	{
		this.nrDomu = nrDomu;
	}
	public String getNrMieszkania() 
	{
		return nrMieszkania;
	}
	public void setNrMieszkania(String nrMieszkania) 
	{
		this.nrMieszkania = nrMieszkania;
	}

}
