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

import com.web.FajneAuto.domain.RentalCarClass;



@Repository
public class RentalCarClassDAO implements IRentalCarClassDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<RentalCarClass> listOfClass = new ArrayList<RentalCarClass>();

	public List<RentalCarClass> ReadList() 
	{
		listOfClass.clear();		
		
		String sqlQuery = "CALL RentOptions_ClassList()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				RentalCarClass carClass = new RentalCarClass();
				
				carClass.setIdRentalClass(rs.getInt("IDRentalClass"));
				carClass.setClassName(rs.getString("ClassName"));
				
				listOfClass.add(carClass);
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
		return listOfClass;
	}

	public RentalCarClass Read(int ID) 
	{
		RentalCarClass carClass = new RentalCarClass();		
		
		String sqlQuery = "CALL RentOptions_ClassDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				carClass.setIdRentalClass(rs.getInt("IDRentalClass"));
				carClass.setClassName(rs.getString("ClassName"));
				carClass.setPricePerDay(rs.getFloat("PricePerDay"));
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
		return carClass;
	}

	public void Update(RentalCarClass R) 
	{
		String sqlQuery = "CALL RentOptions_ClassEdit(?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, R.getIdRentalClass());
			ps.setString(2, R.getClassName());
			ps.setFloat(3, R.getPricePerDay());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(RentalCarClass R) 
	{
		String sqlQuery = "CALL RentOptions_ClassAdd(?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, R.getClassName());
			ps.setFloat(2, R.getPricePerDay());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		
	}

	public void Delete(int ID) 
	{
		String sqlQuery = "CALL RentOptions_ClassRemove(?)";
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
