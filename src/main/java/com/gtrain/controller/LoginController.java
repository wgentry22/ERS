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
		
		System.out.println("Entered login.do");
		
		String username = req.getParameter("loginUsername");
		String password = req.getParameter("loginPassword");
		
		//GET Login
		if (req.getMethod().equals("GET")) {
			return "login.html";
		}
		
		
		//Determines which set of pages to redirect
//		if (Role.isManager(username)) {
//			if (ManagerService.getInstance().login(new Manager(username, password)) instanceof Manager) {
//				Manager authorizedManager = ManagerService.getInstance().getManager(new Manager(username, password));
//				req.getSession().setAttribute("authorizedUser", authorizedManager);
//				return "/html/manager.do";
//			} else {
//				return "/html/login.html";
//			}
//		} else {
//			if (EmployeeService.getInstance().login(new Employee.EmployeeBuilder().username(username).password(password).build()) instanceof Employee) {
//				Employee authorizedEmployee = EmployeeService.getInstance().getEmployee(new Employee.EmployeeBuilder().username(username).build());
//				req.getSession().setAttribute("authorizedUser", authorizedEmployee);
//				
//				return "/html/employee.do";
//			} else {
//				return "/html/login.html";
//			}
//		}
		
		
		if (Role.isManager(username)) {
			if (ManagerService.getInstance().login(new Manager(username, password))) {
				Manager authorizedManager = ManagerService.getInstance().getManager(new Manager(username));
				req.getSession().setAttribute("authorizedUser", authorizedManager);
				return "/html/manager.do";
			} else {
				System.out.println("Invalid Manager Credentials");
				return "/";
			}
		} else if (Role.isEmployee(username)) {
			if (EmployeeService.getInstance().login(new Employee.EmployeeBuilder().username(username).password(password).build())) {
				Employee authorizedEmployee = EmployeeService.getInstance().getEmployee(new Employee.EmployeeBuilder().username(username).build());
				req.getSession().setAttribute("authorizedUser", authorizedEmployee);
				return "/html/employee.do";
			} else {
				System.out.println("Invalid Employee Credentials");
				return "/";
			}
		} else {
			return "/";
		}
	}
	
	
	public static String logout(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Enumeration<String> attr = req.getSession().getAttributeNames();
			while (attr.hasMoreElements()) {
				String name = attr.nextElement();
				req.getSession().removeAttribute(name);
			}
			req.getSession().invalidate();
			resp.setHeader("Cache-Control", "no-cache, no-store");
			resp.setHeader("Pragma", "no-cache");
			resp.sendRedirect("/ERS");
		} catch (IOException e) {
			e.printStackTrace();
			logger.debug(e);
			
		}
		return "";
	}
	
	
	
}
