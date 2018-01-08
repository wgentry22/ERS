package com.gtrain.service;

import java.util.List;

import com.gtrain.model.Employee;
import com.gtrain.dao.EmployeeDaoImplementation;

public class EmployeeService {

	private static EmployeeService employeeService;
	
	private EmployeeService() {}
	
	public static EmployeeService getInstance() {
		if (employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}
	
	
	public boolean register(Employee employee) {
		return EmployeeDaoImplementation.getInstance().insertProcedure(employee);
	}
	
	
	public boolean update(Employee employee) {
		return EmployeeDaoImplementation.getInstance().update(employee);
	}
	
	public Employee getEmployee(Employee employee) {
		return EmployeeDaoImplementation.getInstance().select(employee);
	}
	
	public List<Employee> getAllEmployees() {
		return EmployeeDaoImplementation.getInstance().selectAll();
	}
	
	public Employee login(Employee employee) {
		Employee authorized = EmployeeDaoImplementation.getInstance().select(employee);
		if (authorized.getPassword().equals(EmployeeDaoImplementation.getInstance().getEmployeeHash(employee))) {
			return authorized;
		} else {
			return null;
		}
	}
	
	
}

