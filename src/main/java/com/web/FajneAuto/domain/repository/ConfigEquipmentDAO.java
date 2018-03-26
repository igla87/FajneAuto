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

import com.web.FajneAuto.domain.ConfigEquipment;



@Repository
public class ConfigEquipmentDAO implements IConfigEquipmentDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<ConfigEquipment> listOfEquipment = new ArrayList<ConfigEquipment>();

	public List<ConfigEquipment> ReadList() 
	{
		listOfEquipment.clear();		
		
		String sqlQuery = "CALL Config_EquipmentList()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ConfigEquipment equipment = new ConfigEquipment();
				
				equipment.setIdEquipment(rs.getInt("IDEquipment"));
				equipment.setName(rs.getString("Name"));
				
				listOfEquipment.add(equipment);
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
		return listOfEquipment;
	}

	public ConfigEquipment Read(int ID) 
	{
		ConfigEquipment equipment = new ConfigEquipment();		
		
		String sqlQuery = "CALL Config_EquipmentDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				equipment.setIdEquipment(rs.getInt("IDEquipment"));
				equipment.setName(rs.getString("Name"));	
				equipment.setDescription(rs.getString("Desicription"));				
				equipment.setPrice(rs.getFloat("Price"));
				equipment.setCode(rs.getString("Code"));
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
		return equipment;
	}

	public void Update(ConfigEquipment E) 
	{
		String sqlQuery = "CALL Config_EditEquipment(?,?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, E.getIdEquipment());
			ps.setString(2, E.getName());
			ps.setString(3, E.getDescription());
			ps.setFloat(4, E.getPrice());
			ps.setString(5, E.getCode());		
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(ConfigEquipment E) 
	{
		
		
	}

	public void Delete(int ID) 
	{
		String sqlQuery = "CALL Config_DeleteEquipment(?)";
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
