package com.gtrain.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtrain.ajax.AjaxMessage;
import com.gtrain.model.Employee;
import com.gtrain.service.PendingRequestService;

public class PendingRequestController {

	
	public static Object populate(HttpServletRequest request, HttpServletResponse response) {
		return PendingRequestService.getInstance().selectAllByEmployee((Employee) request.getSession().getAttribute("authorizedUser"));
	}
	
}
