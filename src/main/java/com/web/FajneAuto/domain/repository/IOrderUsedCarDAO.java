package com.web.FajneAuto.domain.repository;

import java.util.List;

import com.web.FajneAuto.domain.OrderUsedCar;

public interface IOrderUsedCarDAO 
{
	List<OrderUsedCar> ReadList();
	List<OrderUsedCar> ReadListByCustomerID(int ID);
	OrderUsedCar Read(int ID);
	void UpdateStatus(String ID, String S);
	void Create(OrderUsedCar O);
	void Delete(int ID);

}
