package com.gtrain.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtrain.controller.EmployeeController;
import com.gtrain.controller.PendingRequestController;

public class AjaxHelper {

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ERS/populatePendingRequestTable.ajax":
			return PendingRequestController.populate(request, response);
		
		default:
			return new AjaxMessage("Not Implemented");
		}
	}
	
}
