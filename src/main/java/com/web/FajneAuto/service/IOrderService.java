package com.web.FajneAuto.service;

import java.util.List;

import com.web.FajneAuto.domain.Order;
import com.web.FajneAuto.domain.OrderConfig;
import com.web.FajneAuto.domain.OrderRent;
import com.web.FajneAuto.domain.OrderUsedCar;

public interface IOrderService 
{
	//public List<OrderUsedCar> ShowUsedCarOrders();
	public List<OrderRent> ShowRentOrders();
	public List<OrderConfig> ShowConfigOrders();
	public List<Order> ShowCustomerOrders(int ID);
	
	public OrderRent ShowRentDetails(String ID);
	public OrderConfig ShowConfigDetails(String ID);
	
	//public void AddUsedCarOrder(OrderUsedCar U);
	public void AddConfigOrder(OrderConfig C);
	public void AddRentOrder(OrderRent R);
	
	//public void DeleteUsedCarOrder(String ID);
	public void DeleteConfigOrder(String ID);
	public void DeleteRentOrder(String ID);
	
	//public void EditUsedCarOrder(String ID, String S);
	public void EditConfigOrder(String ID, String S);
	public void EditRentOrder(String ID, String S);
	
}
