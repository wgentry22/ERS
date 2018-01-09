package com.gtrain.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtrain.model.Employee;
import com.gtrain.service.ResolvedRequestService;

public class ResolvedRequestController {

	public static Object populate(HttpServletRequest req, HttpServletResponse resp) {
		return ResolvedRequestService.getInstance().selectAllByEmployee((Employee) req.getSession().getAttribute("authorizedUser"));
	}
	
	
	public static String show (HttpServletRequest req) {
		return "/employeeResolvedRequest.jsp";
	}
	
}
