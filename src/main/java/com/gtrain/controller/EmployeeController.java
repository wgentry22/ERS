package com.gtrain.controller;



import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.model.Employee;



public class EmployeeController {

	public static String home(HttpServletRequest req) {
		return "/html/employee.jsp";
	}
	
	public static String info(HttpServletRequest req) {
		return "/html/employeeInfo.jsp";
	}
	
	public static String update(HttpServletRequest req) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = req.getReader().readLine();
			
			System.out.println(json);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/html/employeeInfo.jsp";
	}
	
	
}
