package com.web.FajneAuto.domain.repository;

import java.util.List;

import com.web.FajneAuto.domain.Order;
import com.web.FajneAuto.domain.OrderConfig;

public interface IOrderConfigDAO 
{
	List<OrderConfig> ReadList();
	List<Order> ReadListByCustomerID(int ID);
	OrderConfig Read(String ID);
	void UpdateStatus(String ID, String S);
	void Create(OrderConfig O);
	void Delete(String ID);

}
