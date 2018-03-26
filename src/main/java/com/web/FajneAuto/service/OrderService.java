package com.web.FajneAuto.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.FajneAuto.domain.Order;
import com.web.FajneAuto.domain.OrderConfig;
import com.web.FajneAuto.domain.OrderRent;
import com.web.FajneAuto.domain.OrderUsedCar;
import com.web.FajneAuto.domain.repository.OrderConfigDAO;
import com.web.FajneAuto.domain.repository.OrderRentDAO;
//import com.web.FajneAuto.domain.repository.OrderUsedCarDAO;


@Service
public class OrderService implements IOrderService
{
	//@Autowired
	//private OrderUsedCarDAO orderUsedCarDAO;
	
	@Autowired
	private OrderConfigDAO orderConfigDAO;
	
	@Autowired
	private OrderRentDAO orderRentDAO;

	/*public List<OrderUsedCar> ShowUsedCarOrders() 
	{
		return orderUsedCarDAO.ReadList();
	}*/


	public List<OrderRent> ShowRentOrders() 
	{
		return orderRentDAO.ReadList();
	}


	public List<OrderConfig> ShowConfigOrders() 
	{
		return orderConfigDAO.ReadList();
	}


	public List<Order> ShowCustomerOrders(int ID) 
	{
		List<Order> listOfOrders = new ArrayList<Order>();
		
		for(Order o: orderConfigDAO.ReadListByCustomerID(ID))
		{
			listOfOrders.add(o);
		}
		for(Order o: orderRentDAO.ReadListByCustomerID(ID))
		{
			listOfOrders.add(o);
		}	
		
		return listOfOrders;
	}

	public OrderConfig ShowConfigDetails(String ID) 
	{
		return orderConfigDAO.Read(ID);
	}
	
	public OrderRent ShowRentDetails(String ID) 
	{
		return orderRentDAO.Read(ID);
	}

	/*public void AddUsedCarOrder(OrderUsedCar O) 
	{

	}*/


	public void AddConfigOrder(OrderConfig O) 
	{

	}


	public void AddRentOrder(OrderRent O) 
	{
		O.setIdOrder("test");
		O.setIdCar(1);
		
		orderRentDAO.Create(O);
	}


	/*public void DeleteUsedCarOrder(String ID) 
	{

	}*/


	public void DeleteConfigOrder(String ID) 
	{

	}


	public void DeleteRentOrder(String ID) 
	{

	}


	/*public void EditUsedCarOrder(String ID, String S) 
	{

	}*/


	public void EditConfigOrder(String ID, String S) 
	{

	}


	public void EditRentOrder(String ID, String S) 
	{

	}
	
}
