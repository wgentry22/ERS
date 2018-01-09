package com.gtrain.service;

import java.util.List;

import com.gtrain.dao.PendingReqDaoImpl;
import com.gtrain.model.Employee;
import com.gtrain.model.PendingReq;

public class PendingRequestService {

	private static PendingRequestService prs;
	
	private PendingRequestService() {}
	
	public static PendingRequestService getInstance() {
		if (prs == null) {
			prs = new PendingRequestService();
		}
		return prs;
	}
	
	
	public List<PendingReq> selectAll() {
		return PendingReqDaoImpl.getInstance().selectAll();
	}
	
	
	public List<PendingReq> selectAllByEmployee(Employee employee) {
		return PendingReqDaoImpl.getInstance().selectAllByEmployee(employee);
	}
	
	public boolean insert(PendingReq pending) {
		return PendingReqDaoImpl.getInstance().insertProcedure(pending);
	}
}
