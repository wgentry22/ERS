package com.gtrain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtrain.model.PendingReq;
import com.gtrain.service.PendingRequestService;

public class ManagerController {

	public static String home(HttpServletRequest req) {
		return "/html/manager.jsp";
	}
	
	public static List<PendingReq> allRequests(HttpServletRequest req, HttpServletResponse resp) {
		return PendingRequestService.getInstance().selectAll();
	}
}
