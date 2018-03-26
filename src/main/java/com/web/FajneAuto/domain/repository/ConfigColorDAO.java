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

import com.web.FajneAuto.domain.ConfigColor;



@Repository
public class ConfigColorDAO implements IConfigColorDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<ConfigColor> listOfcolors = new ArrayList<ConfigColor>();

	public List<ConfigColor> ReadList() 
	{
		listOfcolors.clear();		
		
		String sqlQuery = "CALL Config_ColorsList()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ConfigColor color = new ConfigColor();
				
				color.setIdColor(rs.getInt("IDColor"));
				color.setColorName(rs.getString("ColorName"));
				
				listOfcolors.add(color);
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
		return listOfcolors;
	}

	public ConfigColor Read(int ID) 
	{
		ConfigColor color = new ConfigColor();		
		
		String sqlQuery = "CALL Config_ColorDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				color.setIdColor(rs.getInt("IDColor"));
				color.setColorName(rs.getString("ColorName"));				
				color.setIDColorType(rs.getInt("IDColorType"));
				color.setCode(rs.getString("Code"));
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
		return color;
	}

	public void Update(ConfigColor C) 
	{
		String sqlQuery = "CALL Config_EditColor(?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, C.getIdColor());
			ps.setString(2, C.getColorName());
			ps.setInt(3, C.getIDColorType());
			ps.setString(4, C.getCode());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(ConfigColor C) 
	{
		
		
	}

	public void Delete(int ID) 
	{
		String sqlQuery = "CALL Config_DeleteColor(?)";
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
