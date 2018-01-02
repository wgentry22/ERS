package com.gtrain.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.gtrain.util.ConnectionUtility;
import com.gtrain.model.Manager;
import com.gtrain.model.Manager.MANAGER;

public class ManagerDaoImplementation implements ManagerDao {

	
	private static ManagerDaoImplementation managerDaoImplementation;
	
	private ManagerDaoImplementation() {}
	
	public static ManagerDaoImplementation getInstance() {
		if (managerDaoImplementation == null) {
			managerDaoImplementation = new ManagerDaoImplementation();
		}
		return managerDaoImplementation;
	}
	
	
	//Prepared Statement to insert new Manager into table
	@Override
	public boolean insert(Manager manager) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			
			int statementIndex = 0;
			
			//Parameterized query to insert record
			String query = "INSERT INTO manager VALUES(NULL, ?, ?, ?, ?)";
			
			//Execute the statement using the prepared statement
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			//Order parameters
			pstmt.setString(++statementIndex, manager.getUsername());
			pstmt.setString(++statementIndex, manager.getPassword());
			pstmt.setString(++statementIndex, manager.getFirstname());
			pstmt.setString(++statementIndex, manager.getLastname());
 
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	@Override
	public boolean insertProcedure(Manager manager) {

		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			//Calling the stored procedure
			String storedProc = "CALL INSERT_MANAGER(?, ?, ?, ?)";
			
			
			CallableStatement cstmt = conn.prepareCall(storedProc);
			
			cstmt.setString(++index, manager.getUsername());
			cstmt.setString(++index, manager.getPassword());
			cstmt.setString(++index, manager.getFirstname());
			cstmt.setString(++index, manager.getLastname());
			
			if (cstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	//Selects a manager based on his username
	@Override
	public Manager select(Manager manager) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String query = "SELECT * FROM manager WHERE M_USERNAME = ?";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(++index, manager.getUsername());
			
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				return new Manager(
				rs.getInt(MANAGER.ID.ordinal()),
				rs.getString(MANAGER.USERNAME.ordinal()),
				rs.getString(MANAGER.PASSWORD.ordinal()),
				rs.getString(MANAGER.FIRSTNAME.ordinal()),
				rs.getString(MANAGER.LASTNAME.ordinal()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Manager();
	}

	@Override
	public List<Manager> selectAll() {

		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "Select * from manager";
			
			PreparedStatement s = conn.prepareStatement(query);
			
			ResultSet rs = s.executeQuery();
			List<Manager> managerList = new ArrayList<>();
			while (rs.next()) {
				managerList.add(new Manager(
						rs.getInt(MANAGER.ID.ordinal()),
						rs.getString(MANAGER.USERNAME.ordinal()),
						rs.getString(MANAGER.USERNAME.ordinal()),
						rs.getString(MANAGER.FIRSTNAME.ordinal()),
						rs.getString(MANAGER.LASTNAME.ordinal())));
			}
			return managerList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	@Override
	public int selectId(Manager manager) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String query = "select m_id from manager where m_username=?";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(++index, manager.getUsername()); 
			
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				return rs.getInt(MANAGER.ID.ordinal());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String getManagerHash(Manager manager) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String query = "SELECT GET_EMPLOYEE_HASH(?, ?) FROM DUAL";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(++index, manager.getUsername());
			pstmt.setString(++index, manager.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				return rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
	
		
	}
}
