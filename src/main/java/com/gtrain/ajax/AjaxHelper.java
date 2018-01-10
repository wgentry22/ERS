package com.gtrain.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtrain.controller.ResolvedRequestController;
import com.gtrain.controller.PendingRequestController;
import com.gtrain.controller.ManagerController;
import com.gtrain.controller.EmployeeController;


public class AjaxHelper {

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ERS/populatePendingRequestTable.ajax":
			return PendingRequestController.populate(request, response);
		case "/ERS/populateResolvedRequest.ajax":
			return ResolvedRequestController.populate(request, response);
		case "/ERS/populateManagerPendingRequestTable.ajax":
			return ManagerController.allRequests(request, response);
		case "/ERS/allEmployees.ajax":
			return EmployeeController.all(request, response);
		case "/ERS/employeeDetailPendingRequest.ajax":
			return PendingRequestController.populateEmployeeDetail(request, response);
		case "/ERS/populateManagerResolvedRequestTable.ajax":
			return ResolvedRequestController.all(request, response);
			
		default:
			return new AjaxMessage("Not Implemented");
		}
	}
	
}
