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

import com.web.FajneAuto.domain.ConfigEquipmentAvailability;



@Repository
public class ConfigEquipmentAvailabilityDAO implements IConfigEquipmentAvailabilityDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<ConfigEquipmentAvailability> listOfEquipmentAv = new ArrayList<ConfigEquipmentAvailability>();

	public List<ConfigEquipmentAvailability> ReadList(int ID) 
	{
		listOfEquipmentAv.clear();		
		
		String sqlQuery = "CALL Config_EquipmentAvList(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ConfigEquipmentAvailability equipmentAv = new ConfigEquipmentAvailability();
				
				equipmentAv.setIdEquipmentAv(rs.getInt("IDEngineAv"));
				equipmentAv.setIdEquipment(ID);
				equipmentAv.setIdModel(rs.getInt("IDModel"));
				equipmentAv.setBasicVersion(rs.getString("BasicVersion"));
				equipmentAv.setStandardVersion(rs.getString("StandardVersion"));
				equipmentAv.setPremiumVersion(rs.getString("PremiumVersion"));
				
				listOfEquipmentAv.add(equipmentAv);
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
		return listOfEquipmentAv;
	}

	public ConfigEquipmentAvailability Read(int ID) 
	{
		ConfigEquipmentAvailability equipmentAv = new ConfigEquipmentAvailability();		
		
		String sqlQuery = "CALL Config_EquipmentAvDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				equipmentAv.setIdEquipmentAv(rs.getInt("IDEngineAv"));
				equipmentAv.setIdEquipment(rs.getInt("IDEquipment"));
				equipmentAv.setIdModel(rs.getInt("IDModel"));
				equipmentAv.setBasicVersion(rs.getString("BasicVersion"));
				equipmentAv.setStandardVersion(rs.getString("StandardVersion"));
				equipmentAv.setPremiumVersion(rs.getString("PremiumVersion"));
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
		return equipmentAv;
	}

	public void Update(ConfigEquipmentAvailability E) 
	{
		String sqlQuery = "CALL Config_EditEquipmentAv(?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, E.getIdEquipmentAv());
			ps.setString(2, E.getBasicVersion());
			ps.setString(3, E.getStandardVersion());
			ps.setString(4, E.getPremiumVersion());	
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(ConfigEquipmentAvailability E) 
	{
		
		
	}

	public void Delete(int ID) 
	{
		String sqlQuery = "CALL Config_DeleteEquipmentAv(?)";
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
