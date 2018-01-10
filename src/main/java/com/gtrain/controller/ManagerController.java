package com.gtrain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.model.Employee;
import com.gtrain.model.PendingReq;
import com.gtrain.service.EmployeeService;
import com.gtrain.service.PendingRequestService;

public class ManagerController {

	public static String home(HttpServletRequest req) {
		return "/html/manager.jsp";
	}
	
	public static List<PendingReq> allRequests(HttpServletRequest req, HttpServletResponse resp) {
		return PendingRequestService.getInstance().selectAll();
	}
	
	public static String showEmployees(HttpServletRequest req) {
		return "/html/allEmployees.jsp";
	}
	
	public static String goToEmployee(HttpServletRequest req) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = req.getReader().readLine();
			System.out.println(json);
			
			Employee employee = EmployeeService.getInstance().getEmployee(mapper.readValue(json, Employee.class));
			System.out.println(employee);
			
			req.getSession().setAttribute("pendingRequestByEmployee", employee);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "/html/employeeDetail.jsp";
	}
}
