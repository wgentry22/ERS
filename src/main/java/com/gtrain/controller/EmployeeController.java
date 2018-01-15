package com.gtrain.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.model.Employee;
import com.gtrain.service.EmployeeService;



public class EmployeeController {

	private static Logger logger = Logger.getLogger(EmployeeController.class);
	
	public static String home(HttpServletRequest req) {
		System.out.println("Entering employee.do");
		return "/html/employee.jsp";
	}
	
	public static String info(HttpServletRequest req) {
		return "employeeInfo.jsp";
	}
	
	public static String update(HttpServletRequest req) {
		
		try {
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String zipcode = req.getParameter("zipcode");

			
			
			Employee currentEmployee = (Employee) req.getSession().getAttribute("authorizedUser");
			Employee updated = new Employee.EmployeeBuilder()
					.id(currentEmployee.getId())
					.username(currentEmployee.getUsername())
					.password(currentEmployee.getPassword())
					.firstname(firstname)
					.lastname(lastname)
					.email(email)
					.address(address)
					.city(city)
					.state(state)
					.zipcode(zipcode)
					.build();
			
			System.out.println("Update: " + updated);
			
			EmployeeService.getInstance().update(updated);
			req.getSession().setAttribute("authorizedUser", updated);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("Ensure all fields are not null");
		}
		
		return "employeeInfo.jsp";
	}
	
	
	
	public static List<Employee> all(HttpServletRequest req, HttpServletResponse resp) {
		return EmployeeService.getInstance().getAllEmployees();
	}
}






