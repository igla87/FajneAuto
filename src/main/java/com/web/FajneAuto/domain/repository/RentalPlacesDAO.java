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

import com.web.FajneAuto.domain.RentalPlaces;



@Repository
public class RentalPlacesDAO implements IRentalPlacesDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<RentalPlaces> listOfPlaces = new ArrayList<RentalPlaces>();

	public List<RentalPlaces> ReadList() 
	{
		listOfPlaces.clear();		
		
		String sqlQuery = "CALL RentOptions_PlacesList()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				RentalPlaces rentPlace = new RentalPlaces();
				
				rentPlace.setIdRentalPlace(rs.getInt("IDRentalPlace"));
				rentPlace.setName(rs.getString("Name"));
				
				listOfPlaces.add(rentPlace);
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
		return listOfPlaces;
	}

	public RentalPlaces Read(int ID) 
	{
		RentalPlaces carClass = new RentalPlaces();		
		
		String sqlQuery = "CALL RentOptions_PlaceDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				carClass.setIdRentalPlace(rs.getInt("IDRentalPlace"));
				carClass.setName(rs.getString("Name"));
				carClass.setAddress(rs.getString("Address"));
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

	public void Update(RentalPlaces R) 
	{
		String sqlQuery = "CALL RentOptions_PlaceEdit(?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, R.getIdRentalPlace());
			ps.setString(2, R.getName());
			ps.setString(3, R.getAddress());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(RentalPlaces R) 
	{
		String sqlQuery = "CALL RentOptions_PlaceAdd(?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, R.getName());
			ps.setString(2, R.getAddress());
			
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
		String sqlQuery = "CALL RentOptions_PlaceRemove(?)";
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
