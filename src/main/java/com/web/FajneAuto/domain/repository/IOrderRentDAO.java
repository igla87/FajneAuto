package com.web.FajneAuto.domain.repository;

import java.util.List;

import com.web.FajneAuto.domain.Order;
import com.web.FajneAuto.domain.OrderRent;

public interface IOrderRentDAO 
{
	List<OrderRent> ReadList();
	List<Order> ReadListByCustomerID(int ID);
	OrderRent Read(String ID);
	void UpdateStatus(String ID, String S);
	void Create(OrderRent O);
	void Delete(String ID);

}
