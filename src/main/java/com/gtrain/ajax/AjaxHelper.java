package com.gtrain.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtrain.controller.ResolvedRequestController;
import com.gtrain.controller.PendingRequestController;
import com.gtrain.controller.ManagerController;


public class AjaxHelper {

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ERS/populatePendingRequestTable.ajax":
			return PendingRequestController.populate(request, response);
		case "/ERS/populateResolvedRequest.ajax":
			return ResolvedRequestController.populate(request, response);
		case "/ERS/populateManagerPendingRequestTable.ajax":
			return ManagerController.allRequests(request, response);
		default:
			return new AjaxMessage("Not Implemented");
		}
	}
	
}
