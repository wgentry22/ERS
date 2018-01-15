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
			
		case "/ERS/html/employee.do":					//Employee Homepage
			return EmployeeController.home(req);
			
		case "/ERS/html/manager.do":					//Manager homepage
			return ManagerController.home(req);
			
		case "/ERS/html/employeeInfo.do": 				//Employee show personal info
			return EmployeeController.info(req);
			
		case "/ERS/html/updateEmployeeInformation.do":	//Employee update personal info
			return EmployeeController.update(req);
			
		case "/ERS/html/employeePendingRequests.do":	//Employee pending request form
			return EmployeeController.pending(req);
			
		case "/ERS/html/employeeResolvedRequest.do":	//Employee view Resolved 
			return EmployeeController.resolved(req);
			
		case "/ERS/html/createPendingRequest.do":		//Employee create pending request
			return PendingRequestController.create(req);
			
		case "/ERS/html/resolvedRequests.do":			//Manager all resolved 
			return ResolvedRequestController.show(req);
			
		case "/ERS/html/allEmployees.do":				//Manager all employees
			return ManagerController.showEmployees(req);
			
		case "/ERS/html/managerViewOfEmployeeInRow.do":
			return ManagerController.setEmployee(req);
			
		case "/ERS/html/goToEmployeeDetail.do":
			return ManagerController.goToEmployee(req);
			
		case "/ERS/html/managerCreateResolved.do":
			return ResolvedRequestController.create(req);
			
		case "/ERS/logout.do":
			return LoginController.logout(req);
		
		default: return "404.jsp";
		}
	}
}
