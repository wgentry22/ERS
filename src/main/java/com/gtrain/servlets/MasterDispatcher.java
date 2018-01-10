package com.gtrain.servlets;

import javax.servlet.http.HttpServletRequest;

import com.gtrain.controller.EmployeeController;
import com.gtrain.controller.LoginController;
import com.gtrain.controller.ManagerController;
import com.gtrain.controller.PendingRequestController;
import com.gtrain.controller.ResolvedRequestController;

public class MasterDispatcher {

	
	public static String process(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/ERS/html/login.do":
			return LoginController.login(req);
		case "/ERS/html/employee.do":
			return EmployeeController.home(req);
		case "/ERS/html/manager.do":
			return ManagerController.home(req);
		case "/ERS/html/employeeInfo.do":
			return EmployeeController.info(req);
		case "/ERS/html/updateEmployeeInformation.do":
			return EmployeeController.update(req);
		case "/ERS/html/createPendingRequest.do":
			return PendingRequestController.create(req);
		case "/ERS/html/resolvedRequests.do":
			return ResolvedRequestController.show(req);
		case "/ERS/html/allEmployees.do":
			return ManagerController.showEmployees(req);
		case "/ERS/html/goToEmployeeDetail.do":
			return ManagerController.goToEmployee(req);
		
		default: return "404.jsp";
		}
	}
}
