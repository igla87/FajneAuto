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

import com.web.FajneAuto.domain.ConfigEngineAvailability;



@Repository
public class ConfigEngineAvailabilityDAO implements IConfigEngineAvailabilityDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<ConfigEngineAvailability> listOfEnginesAv = new ArrayList<ConfigEngineAvailability>();

	public List<ConfigEngineAvailability> ReadList(int ID) 
	{
		listOfEnginesAv.clear();		
		
		String sqlQuery = "CALL Config_EnginesAvList(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ConfigEngineAvailability engineAv = new ConfigEngineAvailability();
				
				engineAv.setIdEngineAv(rs.getInt("IDEngineAv"));
				engineAv.setIdEngine(ID);
				engineAv.setIdModel(rs.getInt("IDModel"));
				engineAv.setBasicVersion(rs.getBoolean("BasicVersion"));
				engineAv.setStandardVersion(rs.getBoolean("StandardVersion"));
				engineAv.setPremiumVersion(rs.getBoolean("PremiumVersion"));
				
				listOfEnginesAv.add(engineAv);
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
		return listOfEnginesAv;
	}

	public ConfigEngineAvailability Read(int ID) 
	{
		ConfigEngineAvailability engineAv = new ConfigEngineAvailability();		
		
		String sqlQuery = "CALL Config_EngineAvDetails(?,?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				engineAv.setIdEngineAv(rs.getInt("IDEngineAv"));
				engineAv.setIdEngine(rs.getInt("IDEngine"));
				engineAv.setIdModel(rs.getInt("IDModel"));
				engineAv.setBasicVersion(rs.getBoolean("BasicVersion"));
				engineAv.setStandardVersion(rs.getBoolean("StandardVersion"));
				engineAv.setPremiumVersion(rs.getBoolean("PremiumVersion"));
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
		return engineAv;
	}

	public void Update(ConfigEngineAvailability E) 
	{
		String sqlQuery = "CALL Config_EditEngineAv(?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, E.getIdEngineAv());
			ps.setBoolean(2, E.isBasicVersion());
			ps.setBoolean(3, E.isStandardVersion());
			ps.setBoolean(4, E.isPremiumVersion());	
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(ConfigEngineAvailability E) 
	{
		
		
	}

	public void Delete(int ID) 
	{
		String sqlQuery = "CALL Config_DeleteEngineAv(?)";
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
