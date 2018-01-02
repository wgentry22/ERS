package com.gtrain.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import com.gtrain.model.Employee;
import com.gtrain.model.Employee.EMPLOYEE;
import com.gtrain.util.ConnectionUtility;

public class EmployeeDaoImplementation implements EmployeeDao {

	private static EmployeeDaoImplementation employeeDaoImplementation;
	
	private EmployeeDaoImplementation() {}
	
	public static EmployeeDaoImplementation getInstance() {
		if (employeeDaoImplementation == null) {
			employeeDaoImplementation = new EmployeeDaoImplementation();
		}
		return employeeDaoImplementation;
	}
	
	
	
	
	// Insert using PreparedStatement
	@Override
	public boolean insert(Employee employee) {

		try (Connection conn = ConnectionUtility.getConnection()) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	@Override
	public boolean insertInformation(Employee employee) {
		
		
		return false;
	}
	
	@Override
	public boolean insertProcedure(Employee employee) {

		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String query = "CALL INSERT_EMPLOYEE(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			CallableStatement p = conn.prepareCall(query);
			
			p.setString(++index, employee.getUsername());
			p.setString(++index, employee.getPassword());
			p.setString(++index, employee.getFirstname());
			p.setString(++index, employee.getLastname());
			p.setString(++index, employee.getEmail());
			p.setString(++index, employee.getAddress());
			p.setString(++index, employee.getCity());
			p.setString(++index, employee.getState());
			p.setString(++index, employee.getZipcode());
			
			if (p.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	//Selects employee by username
	@Override
	public Employee select(Employee employee) {

		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String sql = "SELECT * FROM employee inner join employee_info on e_id = e_info_id where e_username = ?";
			
			PreparedStatement p = conn.prepareStatement(sql);
			
			p.setString(++index, employee.getUsername());
			
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				return new Employee.EmployeeBuilder().id(rs.getInt(EMPLOYEE.ID.ordinal()))
						.username(rs.getString(EMPLOYEE.USERNAME.ordinal()))
						.password(rs.getString(EMPLOYEE.PASSWORD.ordinal()))
						.firstname(rs.getString(EMPLOYEE.FIRSTNAME.ordinal()))
						.lastname(rs.getString(EMPLOYEE.LASTNAME.ordinal()))
						.email(rs.getString(EMPLOYEE.EMAIL.ordinal()))
						.address(rs.getString(EMPLOYEE.ADDRESS.ordinal()))
						.city(rs.getString(EMPLOYEE.CITY.ordinal()))
						.state(rs.getString(EMPLOYEE.CITY.ordinal()))
						.zipcode(rs.getString(EMPLOYEE.ZIPCODE.ordinal()))
						.build();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Employee.EmployeeBuilder().build();
	}

	@Override
	public List<Employee> selectAll() {

		try (Connection conn = ConnectionUtility.getConnection()) {
			
			String query = "select * from employee inner join employee_info on e_id = e_info_id";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			List<Employee> employeeList = new ArrayList<Employee>();
			
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				employeeList.add(new Employee.EmployeeBuilder()
						.id(rs.getInt(EMPLOYEE.ID.ordinal()))
						.username(rs.getString(EMPLOYEE.USERNAME.ordinal()))
						.password(rs.getString(EMPLOYEE.PASSWORD.ordinal()))
						.firstname(rs.getString(EMPLOYEE.FIRSTNAME.ordinal()))
						.lastname(rs.getString(EMPLOYEE.LASTNAME.ordinal()))
						.email(rs.getString(EMPLOYEE.EMAIL.ordinal()))
						.address(rs.getString(EMPLOYEE.ADDRESS.ordinal()))
						.city(rs.getString(EMPLOYEE.CITY.ordinal()))
						.state(rs.getString(EMPLOYEE.CITY.ordinal()))
						.zipcode(rs.getString(EMPLOYEE.ZIPCODE.ordinal()))
						.build());
			}
			return employeeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return new ArrayList<>();
	}
	
	//Returns id of employee based on Username
	@Override
	public int selectId(Employee employee) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String query = "select e_id from employee where e_username = ?";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(++index, employee.getUsername());
			
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				return rs.getInt(EMPLOYEE.ID.ordinal());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;	//return value of -1 implies Employee is not found
	}

	@Override
	public String getEmployeeHash(Employee employee) {

		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String query = "select GET_EMPLOYEE_HASH(?, ?)";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(++index, employee.getUsername());
			p.setString(++index, employee.getPassword());
			
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				return rs.getString(EMPLOYEE.PASSWORD.ordinal());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


}
