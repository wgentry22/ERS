package com.gtrain.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtrain.controller.EmployeeController;
import com.gtrain.controller.LoginController;
import com.gtrain.controller.ManagerController;
import com.gtrain.controller.PendingRequestController;
import com.gtrain.controller.ResolvedRequestController;

public class MasterDispatcher {

	
	public static String process(HttpServletRequest req, HttpServletResponse resp) {
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
			
		case "/ERS/html/managerViewOfEmployeeInRow.do":
			return ManagerController.setEmployee(req);
			
		case "/ERS/html/goToEmployeeDetail.do":
			return ManagerController.goToEmployee(req);
			
		case "/ERS/html/managerCreateResolved.do":
			return ResolvedRequestController.create(req);
			
		case "/ERS/html/logout.do":
			return LoginController.logout(req, resp);
		
		default: return "404.jsp";
		}
	}
}
