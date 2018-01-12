package com.gtrain.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.model.Employee;
import com.gtrain.model.Manager;
import com.gtrain.model.ResolvedReq;
import com.gtrain.service.ResolvedRequestService;

public class ResolvedRequestController {
	
	private static Logger logger = Logger.getLogger(ResolvedRequestController.class);

	public static Object populate(HttpServletRequest req, HttpServletResponse resp) {
		return ResolvedRequestService.getInstance().selectAllByEmployee((Employee) req.getSession().getAttribute("authorizedUser"));
	}
	
	public static String create(HttpServletRequest req) {
		Manager manager = (Manager) req.getSession().getAttribute("authorizedUser");
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = req.getReader().readLine();
			
			System.out.println(json);
			
			ResolvedReq temp = mapper.readValue(json, ResolvedReq.class);
			
			ResolvedReq resolved = new ResolvedReq(temp.getPendingRequestId(), manager.getId(), temp.getResolvedStatus());
			
			System.out.println(resolved);
			
			ResolvedRequestService.getInstance().insert(resolved);
			
			req.getSession().setAttribute("pendingRequestByEmployee", null);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		return "/html/manager.jsp";
	}
	
	public static String show (HttpServletRequest req) {
		return "/employeeResolvedRequest.jsp";
	}
	
	public static Object all(HttpServletRequest req, HttpServletResponse resp) {
		return ResolvedRequestService.getInstance().selectAll();
	}
	
	
}
