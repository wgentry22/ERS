package com.gtrain.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.model.Employee;
import com.gtrain.service.EmployeeService;



public class EmployeeController {

	public static String home(HttpServletRequest req) {
		return "employee.jsp";
	}
	
	public static String info(HttpServletRequest req) {
		return "employeeInfo.jsp";
	}
	
	public static String update(HttpServletRequest req) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = req.getReader().readLine();
			
			System.out.println(json);
			
			Employee employee =  mapper.readValue(json, Employee.class);
			Employee currentEmployee = (Employee) req.getSession().getAttribute("authorizedUser");
			Employee updated = new Employee.EmployeeBuilder()
					.id(currentEmployee.getId())
					.username(currentEmployee.getUsername())
					.password(currentEmployee.getPassword())
					.firstname(employee.getFirstname())
					.lastname(employee.getLastname())
					.email(employee.getEmail())
					.address(employee.getAddress())
					.city(employee.getCity())
					.state(employee.getState())
					.zipcode(employee.getZipcode())
					.build();
			
			System.out.println("Update: " + updated);
			
			EmployeeService.getInstance().update(updated);
			req.getSession().setAttribute("authorizedUser", updated);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "employee.jsp";
	}
	
	
	
	public static List<Employee> all(HttpServletRequest req, HttpServletResponse resp) {
		return EmployeeService.getInstance().getAllEmployees();
	}
}






