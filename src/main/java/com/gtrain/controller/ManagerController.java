package com.gtrain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.model.Employee;
import com.gtrain.model.PendingReq;
import com.gtrain.service.EmployeeService;
import com.gtrain.service.PendingRequestService;

public class ManagerController {

	private static Logger logger = Logger.getLogger(ManagerController.class);
	
	public static String home(HttpServletRequest req) {
		System.out.println("Entering manager.do");
		req.getSession().setAttribute("pendingRequestByEmployee", null);
		return "/html/manager.jsp";
	}
	
	public static List<PendingReq> allRequests(HttpServletRequest req, HttpServletResponse resp) {
		return PendingRequestService.getInstance().selectAll();
	}
	
	public static String showEmployees(HttpServletRequest req) {
		System.out.println("Entering all employees");
		return "/html/allEmployees.jsp";
	}
	
	public static String setEmployee(HttpServletRequest req) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = req.getReader().readLine();
			
			Employee temp = mapper.readValue(json, Employee.class);
			Employee employee = EmployeeService.getInstance().getEmployee(temp);
			
			req.getSession().setAttribute("employeeDetail", employee);
			
			System.out.println(employee);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e);
		}
		return "/html/employeeDetail.jsp";
	}
	
	public static String goToEmployee(HttpServletRequest req) {
		
		return "/html/employeeDetail.jsp";
	}
}
