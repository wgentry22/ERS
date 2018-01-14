package com.gtrain.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gtrain.ajax.Role;
import com.gtrain.model.Employee;
import com.gtrain.model.Manager;
import com.gtrain.service.EmployeeService;
import com.gtrain.service.ManagerService;

public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);
	
	public static String login(HttpServletRequest req) {
		
		
		
		String username = req.getParameter("loginUsername");
		String password = req.getParameter("loginPassword");
		
		//GET Login
		if (req.getMethod().equals("GET")) {
			return "login.html";
		}
		
		
		//Determines which set of pages to redirect
		if (Role.isManager(username)) {
			Manager authorizedManager = null;
			if (ManagerService.getInstance().login(new Manager(username, password)) instanceof Manager) {
				authorizedManager = ManagerService.getInstance().getManager(new Manager(username, password));
				req.getSession().setAttribute("authorizedUser", authorizedManager);
				return "/html/manager.do";
			} else {
				return "login.html";
			}
		} else {
			Employee authorizedEmployee = null;
			if (EmployeeService.getInstance().login(new Employee.EmployeeBuilder().username(username).password(password).build()) instanceof Employee) {
				authorizedEmployee = EmployeeService.getInstance().getEmployee(new Employee.EmployeeBuilder().username(username).build());
				req.getSession().setAttribute("authorizedUser", authorizedEmployee);
				
				return "/html/employee.do";
			} else {
				return "login.html";
			}
		}		
	}
	
	
	public static String logout(HttpServletRequest req, HttpServletResponse resp) {
		resp.setHeader("Cache-Control", "no-cache, no-store");
		resp.setHeader("Pragma", "no-cache");
		Enumeration<String> attr = req.getSession().getAttributeNames();
		while (attr.hasMoreElements()) {
			String name = attr.nextElement();
			req.getSession().removeAttribute(name);
		}
		
		req.getSession().invalidate();
		try {
			resp.sendRedirect("/ERS");
		} catch (IOException e) {
			e.printStackTrace();
			logger.debug(e);
			
		}
		return "";
	}
	
	
	
}
