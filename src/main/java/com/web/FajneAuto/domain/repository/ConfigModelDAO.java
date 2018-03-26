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

import com.web.FajneAuto.domain.ConfigModel;



@Repository
public class ConfigModelDAO implements IConfigModelDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<ConfigModel> listOfModels = new ArrayList<ConfigModel>();

	public List<ConfigModel> ReadList() 
	{
		listOfModels.clear();		
		
		String sqlQuery = "CALL Config_ModelsList()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ConfigModel model = new ConfigModel();
				
				model.setIdModel(rs.getInt("IDModel"));
				model.setName(rs.getString("ModelName"));
				
				listOfModels.add(model);
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
		return listOfModels;
	}

	public ConfigModel Read(int ID) 
	{
		ConfigModel model = new ConfigModel();		
		
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
				model.setIdModel(rs.getInt("IDRentalClass"));
				model.setName(rs.getString("ModelName"));				
				model.setBasicPrice(rs.getFloat("BasicPrice"));
				model.setStandardPrice(rs.getFloat("StandardPrice"));
				model.setPremiumPrice(rs.getFloat("PremiumPrice"));
				model.setCode(rs.getString("Code"));
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
		return model;
	}

	public void Update(ConfigModel M) 
	{
		String sqlQuery = "CALL Confog_EditModel(?,?,?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, M.getIdModel());
			ps.setString(2, M.getName());
			ps.setFloat(3, M.getBasicPrice());
			ps.setFloat(4, M.getStandardPrice());
			ps.setFloat(5, M.getPremiumPrice());
			ps.setString(6, M.getCode());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(ConfigModel M) 
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
