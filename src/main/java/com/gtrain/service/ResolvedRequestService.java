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
	
	public ResolvedReq select(ResolvedReq resolved) {
		return ResolvedReqDaoImpl.getInstance().select(resolved);
	}
	
	public boolean insert(ResolvedReq resolved) {
		return ResolvedReqDaoImpl.getInstance().insertProcedure(resolved);
	}
	
	public List<ResolvedReq> selectAll() {
		return ResolvedReqDaoImpl.getInstance().selectAll();
	}
	
	public List<ResolvedReq> selectAllByEmployee(Employee employee) {
		return ResolvedReqDaoImpl.getInstance().selectAllByEmployee(employee);
	}
	
	
}
