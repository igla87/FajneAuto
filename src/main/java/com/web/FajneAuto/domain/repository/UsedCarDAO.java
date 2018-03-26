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

import com.web.FajneAuto.domain.UsedCar;



@Repository
public class UsedCarDAO implements IUsedCarDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<UsedCar> listOfCars = new ArrayList<UsedCar>();

	public List<UsedCar> ReadList() 
	{
		listOfCars.clear();		
		
		String sqlQuery = "CALL UsedCar_List()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				UsedCar car = new UsedCar();
				
				car.setIdCar(rs.getInt("IDCar"));
				car.setBrand(rs.getString("Brand"));
				car.setModel(rs.getString("Model"));
				car.setProductionYear(rs.getInt("ProductionYear"));
				car.setEngineCapacity(rs.getInt("EngineCapacity"));
				car.setSellPrice(rs.getFloat("SellPrice"));
				
				listOfCars.add(car);
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
		return listOfCars;
	}

	public UsedCar Read(int ID) 
	{
		UsedCar car = new UsedCar();		
		
		String sqlQuery = "CALL UsedCar_ShowDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				car.setIdCar(rs.getInt("IDCar"));
				car.setBrand(rs.getString("Brand"));
				car.setModel(rs.getString("Model"));
				car.setVersion(rs.getString("Version"));
				car.setProductionYear(rs.getInt("ProductionYear"));
				car.setColor(rs.getString("Color"));
				car.setEngineDesignation(rs.getString("EngineDesignation"));
				car.setEngineCapacity(rs.getInt("EngineCapacity"));
				car.setHP(rs.getInt("HorsePower"));
				car.setDescription(rs.getString("Description"));
				car.setSellPrice(rs.getFloat("SellPrice"));
				car.setIDRentalClass(rs.getInt("IDRentalClass"));
				car.setAvailable(rs.getBoolean("IsAvailable"));
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
		return car;
	}

	public void Update(UsedCar U) 
	{
		String sqlQuery = "CALL UsedCar_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, U.getIdCar());
			ps.setString(2, U.getBrand());
			ps.setString(3, U.getModel());
			ps.setString(4, U.getVersion());
			ps.setInt(5, U.getProductionYear());
			ps.setString(6, U.getColor());
			ps.setString(7, U.getEngineDesignation());
			ps.setString(8, U.getEngineFuel());
			ps.setInt(9, U.getEngineCapacity());
			ps.setInt(10, U.getHP());
			ps.setString(11, U.getDescription());
			ps.setFloat(12, U.getSellPrice());
			ps.setInt(13, U.getIDRentalClass());
			ps.setBoolean(14, U.isAvailable());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(UsedCar U) 
	{
		
		
	}

	public void Delete(int ID) 
	{
		String sqlQuery = "CALL UsedCar_Remove (?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}
}
