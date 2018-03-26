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

import com.web.FajneAuto.domain.User;

@Repository
public class UserDAO implements IUserDAO
{
	@Autowired
	private DataSource dataSource;
	
	List<User> listOfCustomers = new ArrayList<User>();

	public List<User> ReadList(String R) 
	{
		listOfCustomers.clear();		
		
		String sqlQuery = "CALL User_List(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, R);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				User user = new User();
				
				user.setId(rs.getInt("IDUser"));
				user.setName(rs.getString("Name"));
				user.setSurname(rs.getString("Surname"));
				user.setLogin(rs.getString("Login"));
				user.setEmail(rs.getString("Email"));
				
				listOfCustomers.add(user);
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
		return listOfCustomers;
	}

	public User ReadByID(int ID) 
	{
		User user = new User();		
		
		String sqlQuery = "CALL User_ShowDetailsByID(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				user.setId(rs.getInt("IDUser"));
				user.setName(rs.getString("Name"));
				user.setSurname(rs.getString("Surname"));
				user.setAddressCity(rs.getString("AddressCity"));
				user.setAddressPostCode(rs.getString("AddressPostCode"));
				user.setAddressStreet(rs.getString("AddressStreet"));
				user.setPhone(rs.getString("Phone"));
				user.setEmail(rs.getString("Email"));
				user.setLogin(rs.getString("Login"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getString("Role"));
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
		return user;
	}
	
	public User ReadByName(String N) 
	{
		User user = new User();		
		
		String sqlQuery = "CALL User_ShowDetailsByName(?)";
		Connection con = null;
		
		try
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, N);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				user.setId(rs.getInt("IDUser"));
				user.setName(rs.getString("Name"));
				user.setSurname(rs.getString("Surname"));
				user.setAddressCity(rs.getString("AddressCity"));
				user.setAddressPostCode(rs.getString("AddressPostCode"));
				user.setAddressStreet(rs.getString("AddressStreet"));
				user.setPhone(rs.getString("Phone"));
				user.setEmail(rs.getString("Email"));
				user.setLogin(rs.getString("Login"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getString("Role"));
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
		return user;
	}

	public void UpdateData(User U) 
	{
		String sqlQuery = "CALL User_UpdateData(?,?,?,?,?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, U.getId());
			ps.setString(2, U.getName());
			ps.setString(3, U.getSurname());
			ps.setString(4, U.getAddressCity());
			ps.setString(5, U.getAddressPostCode());
			ps.setString(6, U.getAddressStreet());
			ps.setString(7, U.getPhone());
			ps.setString(8, U.getEmail());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}
	
	public void UpdatePassword(User U) 
	{
		String sqlQuery = "CALL User_UpdateData(?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, U.getId());
			ps.setString(2, U.getPassword());
			
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	public void Create(User U) 
	{
		String sqlQuery = "CALL User_Register(?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		
		try 
		{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, U.getName());
			ps.setString(2, U.getSurname());
			ps.setString(3, U.getAddressCity());
			ps.setString(4, U.getAddressPostCode());
			ps.setString(5, U.getAddressStreet());
			ps.setString(6, U.getPhone());
			ps.setString(7, U.getEmail());
			ps.setString(8, U.getLogin());
			ps.setString(9, U.getPassword());
			ps.setString(10, "CUSTOMER");
			
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
		String sqlQuery = "CALL User_Delete (?)";
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
