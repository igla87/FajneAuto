package com.web.FajneAuto.domain;

import java.util.Date;

public class OrderUsedCar extends Order
{
	private int idCar;
	private Date deliveryDate;
	
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
