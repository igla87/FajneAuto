package com.web.FajneAuto.domain;

public class RentalPeriod 
{
	public RentalPeriod()
	{
		super();
	}
	
	private int idRentalPeriod;
	private String periodName;
	private int daysMin;
	private  int daysMax;
	private  float priceModifier;
	
	public int getIdRentalPeriod() {
		return idRentalPeriod;
	}
	public void setIdRentalPeriod(int iDRentalPeriod) {
		idRentalPeriod = iDRentalPeriod;
	}
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	public int getDaysMin() {
		return daysMin;
	}
	public void setDaysMin(int daysMin) {
		this.daysMin = daysMin;
	}
	public int getDaysMax() {
		return daysMax;
	}
	public void setDaysMax(int daysMax) {
		this.daysMax = daysMax;
	}
	public float getPriceModifier() {
		return priceModifier;
	}
	public void setPriceModifier(float priceModifier) {
		this.priceModifier = priceModifier;
	}

}
