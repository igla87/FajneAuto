package com.web.FajneAuto.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.FajneAuto.domain.Order;
import com.web.FajneAuto.domain.OrderConfig;


@Repository
public class OrderConfigDAO implements IOrderConfigDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<OrderConfig> listOfConfigOrders = new ArrayList<OrderConfig>();
	List<Order> listOfOrders = new ArrayList<Order>();

	public List<OrderConfig> ReadList() 
	{
		listOfConfigOrders.clear();		
		
		String sqlQuery = "CALL Orders_Config_List()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				OrderConfig order = new OrderConfig();
				
				order.setIdOrder(rs.getString("IDOrder"));
				order.setIdCustomer(rs.getInt("IDCustomer"));
				
				listOfConfigOrders.add(order);
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
		return listOfConfigOrders;
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

	public OrderConfig Read(String ID) 
	{
		OrderConfig order = new OrderConfig();		
		
		String sqlQuery = "CALL Orders_Config_ShowDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				order.setIdOrder(rs.getString(""));
				order.setIdCustomer(rs.getInt(""));				
				order.setConfigNr(rs.getString(""));
				order.setDeliveryDate(rs.getDate(""));
				order.setDateOfOrder(rs.getDate(""));
				order.setFinalPrice(rs.getFloat(""));
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
		String sqlQuery = "CALL Order_Config_EditStatus(?,?)";
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

	public void Create(OrderConfig O) 
	{
		
		
	}

	public void Delete(String ID) 
	{
		String sqlQuery = "CALL Order_Config_Delete(?)";
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
