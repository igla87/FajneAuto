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

import com.web.FajneAuto.domain.RentalPeriod;



@Repository
public class RentalPeriodDAO implements IRentalPeriodDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<RentalPeriod> periodList = new ArrayList<RentalPeriod>();

	public List<RentalPeriod> ReadList() 
	{
		periodList.clear();		
		
		String sqlQuery = "CALL RentOptions_PeriodList()";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				RentalPeriod period = new RentalPeriod();
				
				period.setIdRentalPeriod(rs.getInt("IDRentalPeriod"));
				period.setPeriodName(rs.getString("PeriodName"));
				period.setDaysMin(rs.getInt("DaysMin"));
				period.setDaysMax(rs.getInt("DaysMax"));
				period.setPriceModifier(rs.getFloat("PriceModifier"));
				
				periodList.add(period);
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
		return periodList;
	}
	
	public RentalPeriod Read(int ID) 
	{
		RentalPeriod period = new RentalPeriod();		
		
		String sqlQuery = "CALL RentOptions_PeriodDetails(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				period.setIdRentalPeriod(rs.getInt("IDRentalPeriod"));
				period.setPeriodName(rs.getString("PeriodName"));
				period.setDaysMin(rs.getInt("DaysMin"));
				period.setDaysMax(rs.getInt("DaysMax"));
				period.setPriceModifier(rs.getFloat("PriceModifier"));
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
		return period;
	}

	public void Update(RentalPeriod R) 
	{
		String sqlQuery = "CALL RentOptions_PeriodEdit(?,?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, R.getIdRentalPeriod());
			ps.setString(2, R.getPeriodName());
			ps.setInt(3, R.getDaysMin());
			ps.setInt(4, R.getDaysMax());
			ps.setFloat(5, R.getPriceModifier());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(RentalPeriod R) 
	{
		String sqlQuery = "CALL RentOptions_PeriodAdd(?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, R.getPeriodName());
			ps.setInt(2, R.getDaysMin());
			ps.setInt(2, R.getDaysMax());
			ps.setFloat(2, R.getPriceModifier());
			
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
		String sqlQuery = "CALL RentOptions_PeriodRemove(?)";
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
