package com.gtrain.service;

import java.util.List;


import com.gtrain.dao.ResolvedReqDaoImpl;
import com.gtrain.model.Employee;
import com.gtrain.model.ResolvedReq;

public class ResolvedRequestService {

	private static ResolvedRequestService rrs;
	
	private ResolvedRequestService(){}
	
	public static ResolvedRequestService getInstance() {
		if (rrs == null) {
			rrs = new ResolvedRequestService();
		}
		return rrs;
	}
	
	public List<ResolvedReq> selectAllByEmployee(Employee employee) {
		return ResolvedReqDaoImpl.getInstance().selectAllByEmployee(employee);
	}
	
	
}
