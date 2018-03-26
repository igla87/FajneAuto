package com.web.FajneAuto.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.FajneAuto.domain.Order;
import com.web.FajneAuto.domain.OrderRent;



@Repository
public class OrderRentDAO implements IOrderRentDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<OrderRent> listOfRentOrders = new ArrayList<OrderRent>();
	List<Order> listOfOrders = new ArrayList<Order>();

	public List<OrderRent> ReadList() 
	{
		listOfRentOrders.clear();		
		
		String sqlQuery = "CALL Orders_Rent_List()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				OrderRent order = new OrderRent();
				
				order.setIdOrder(rs.getString("IDOrder"));
				order.setIdCustomer(rs.getInt("IDCustomer"));
				
				listOfRentOrders.add(order);
			}
			rs.close();
			ps.close();
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e) {}
			}
		}
		return listOfRentOrders;
	}
	
	public List<Order> ReadListByCustomerID(int ID) 
	{
		listOfOrders.clear();		
		
		String sqlQuery = "CALL Orders_Rent_List_ByID(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Order order = new Order();
				
				order.setIdOrder(rs.getString("IDOrder"));
				order.setDateOfOrder(rs.getDate("DateOfOrder"));
				
				listOfOrders.add(order);
			}
			rs.close();
			ps.close();
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e) {}
			}
		}
		return listOfOrders;
	}

	public OrderRent Read(String ID) 
	{
		OrderRent order = new OrderRent();		
		
		String sqlQuery = "CALL Orders_Rent_ShowDetails(?)";
		Connection con = null;
		
		//java.sql.Date dataSQL = new java.sql.Date(0);
		//java.util.Date dataJAVA;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				order.setIdOrder(rs.getString("IDRent"));
				order.setIdCustomer(rs.getInt("IDCustomer"));				
				order.setIdCar(rs.getInt("IDCar"));
				order.setStartPlaceID(rs.getInt("StartPlaceID"));
				order.setEndPlaceID(rs.getInt("EndPlaceID"));
				
				//dataSQL = rs.getDate("StartDate");
				//dataJAVA = dataSQL;
				//order.setStartDate(dataJAVA);
				
				order.setStartDate(rs.getTimestamp("StartDate"));
				order.setEndDate(rs.getTimestamp("EndDate"));
				order.setDateOfOrder(rs.getTimestamp("DateOfOrder"));
				order.setFinalPrice(rs.getFloat("FinalPrice"));
			}
			rs.close();
			ps.close();
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e) {}
			}
		}
		return order;
	}

	public void UpdateStatus(String ID, String S) 
	{
		String sqlQuery = "CALL Orders_Rent_EditStatus(?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, ID);
			ps.setString(2, S);
						
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(OrderRent O) 
	{
		//IDRent, IDCustomer, IDCar, DateOfOrder, StartDate, EndDate, StartPlace, EndPlace, FinalPrice
		String sqlQuery = "CALL Orders_Rent_Add(?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, O.getIdOrder());
			ps.setInt(2, O.getIdCustomer());
			ps.setInt(3, O.getIdCar());			
			ps.setTimestamp(4, (Timestamp) O.getDateOfOrder());
			ps.setTimestamp(5, (Timestamp) O.getStartDate());
			ps.setTimestamp(6, (Timestamp) O.getEndDate());
			ps.setInt(7, O.getStartPlaceID());
			ps.setInt(8, O.getEndPlaceID());
			ps.setFloat(9, O.getFinalPrice());
			
						
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		
	}

	public void Delete(String ID) 
	{
		String sqlQuery = "CALL Orders_Rent_Delete(?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, ID);
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}
}
