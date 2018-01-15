package com.gtrain.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.model.Employee;
import com.gtrain.model.PendingReq;
import com.gtrain.service.PendingRequestService;

public class PendingRequestController {

	private static Logger logger = Logger.getLogger(PendingRequestController.class);
	
	public static Object populate(HttpServletRequest request, HttpServletResponse response) {
		return PendingRequestService.getInstance().selectAllByEmployee((Employee) request.getSession().getAttribute("authorizedUser"));
	}
	
	public static Object populateEmployeeDetail(HttpServletRequest request, HttpServletResponse response) {
		return PendingRequestService.getInstance().selectAllByEmployee((Employee) request.getSession().getAttribute("employeeDetail"));
	}
	
	public static String create(HttpServletRequest req) {
		System.out.println("Creating Pending Request");
		try {
			Employee employee = (Employee) req.getSession().getAttribute("authorizedUser");
			String amount = req.getParameter("requestAmount");
			String reason = req.getParameter("requestReason");
			System.out.println("Current Employee: " + employee);
			
			
			PendingReq pending = new PendingReq(employee.getId(), amount, reason);
			System.out.println(pending);
			
			PendingRequestService.getInstance().insert(pending);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(e);
		}
		
		
		return "/html/employee.jsp";
	}
	
}
