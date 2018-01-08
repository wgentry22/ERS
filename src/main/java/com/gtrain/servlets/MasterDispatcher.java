package com.gtrain.servlets;

import javax.servlet.http.HttpServletRequest;

import com.gtrain.controller.EmployeeController;
import com.gtrain.controller.LoginController;
import com.gtrain.controller.ManagerController;

public class MasterDispatcher {

	
	public static String process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/ERS/html/login.do":
			return LoginController.login(req);
		case "/ERS/employee.do":
			return EmployeeController.home(req);
		case "/ERS/manager.do":
			return ManagerController.home(req);
		case "/ERS/html/employeeInfo.do":
			return EmployeeController.info(req);
		case "/ERS/html/updateEmployeeInformation.do":
			return EmployeeController.update(req);
		default: return "404.jsp";
		}
	}
}
