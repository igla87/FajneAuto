package com.web.FajneAuto.domain;

import java.util.Date;

public class OrderConfig extends Order
{
	private String configNr;
	private Date deliveryDate;
	
	public String getConfigNr() {
		return configNr;
	}
	public void setConfigNr(String configNr) {
		this.configNr = configNr;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
