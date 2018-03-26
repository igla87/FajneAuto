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

import com.web.FajneAuto.domain.ConfigEngine;



@Repository
public class ConfigEngineDAO implements IConfigEngineDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<ConfigEngine> listOfEngines = new ArrayList<ConfigEngine>();

	public List<ConfigEngine> ReadList() 
	{
		listOfEngines.clear();		
		
		String sqlQuery = "CALL Config_ModelsList()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ConfigEngine model = new ConfigEngine();
				
				model.setIdEngine(rs.getInt("IDEngine"));
				model.setDesignation(rs.getString("Designation"));
				
				listOfEngines.add(model);
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
		return listOfEngines;
	}

	public ConfigEngine Read(int ID) 
	{
		ConfigEngine engine = new ConfigEngine();		
		
		String sqlQuery = "CALL Config_ModelDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				engine.setIdEngine(rs.getInt("IDEngine"));
				engine.setDesignation(rs.getString("Designation"));				
				engine.setFuelType(rs.getString("FuelType"));
				engine.setCapacity(rs.getInt("Capacity"));
				engine.setHp(rs.getInt("HorsePower"));
				engine.setAcceleration(rs.getFloat("Acceleration"));
				engine.setCombustion(rs.getFloat("Combustion"));
				engine.setEmission(rs.getInt("Emission"));
				engine.setPrice(rs.getFloat("Price"));
				engine.setCode(rs.getString("Code"));
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
		return engine;
	}

	public void Update(ConfigEngine E) 
	{
		String sqlQuery = "CALL Confog_EditModel(?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, E.getIdEngine());
			ps.setString(2, E.getDesignation());
			ps.setString(3, E.getFuelType());
			ps.setInt(4, E.getCapacity());
			ps.setInt(5, E.getHp());
			ps.setFloat(6, E.getAcceleration());
			ps.setFloat(7, E.getCombustion());
			ps.setInt(8, E.getEmission());
			ps.setFloat(9, E.getPrice());
			ps.setString(10, E.getCode());		
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(ConfigEngine E) 
	{
		
		
	}

	public void Delete(int ID) 
	{
		String sqlQuery = "CALL Config_DeleteModel(?)";
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
