package com.gtrain.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.model.Employee;
import com.gtrain.model.PendingReq;
import com.gtrain.service.PendingRequestService;

public class PendingRequestController {

	
	public static Object populate(HttpServletRequest request, HttpServletResponse response) {
		return PendingRequestService.getInstance().selectAllByEmployee((Employee) request.getSession().getAttribute("authorizedUser"));
	}
	
	public static Object populateEmployeeDetail(HttpServletRequest request, HttpServletResponse response) {
		return PendingRequestService.getInstance().selectAllByEmployee((Employee) request.getSession().getAttribute("pendingRequestByEmployee"));
	}
	
	public static String create(HttpServletRequest req) {
		
		try {
			String json = req.getReader().readLine().toString();
			Employee employee = (Employee) req.getSession().getAttribute("authorizedUser");
			System.out.println("Incoming JSON: " + json);
			System.out.println("Current Employee: " + employee);
			
			PendingReq newPending = new ObjectMapper().readValue(json, PendingReq.class);
			
			
			PendingReq pending = new PendingReq(employee.getId(), newPending.getRequestAmount().toString(), newPending.getRequestReason());
			System.out.println(pending);
			
			PendingRequestService.getInstance().insert(pending);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/html/employee.jsp";
	}
	
}
