package com.gtrain.Testing;

import com.gtrain.dao.ManagerDaoImplementation;
import com.gtrain.dao.PendingReqDaoImpl;
import com.gtrain.dao.ResolvedReqDaoImpl;
import com.gtrain.model.Employee;
import com.gtrain.model.Manager;
import com.gtrain.model.PendingReq;
import com.gtrain.model.ResolvedReq;
import com.gtrain.service.EmployeeService;

public class ModelFieldsNotNull {

	
	public boolean employeeFieldsNotNull() {
		int result = 0;
		for (Employee e : EmployeeService.getInstance().getAllEmployees()) {
			if (e.getCity() == null || e.getAddress() == null || e.getState() == null || e.getZipcode() == null) {
				result++;
			}
		}
		
		return result == 0 ? true : false;
	}
	
	public boolean managerFieldsNotNull() {
		int result = 0;
		for (Manager m : ManagerDaoImplementation.getInstance().selectAll()) {
			if (m.getFirstname() == null || m.getLastname() == null) {
				result++;
			}
		}
		return result == 0 ? true : false;
	}
	
	public boolean pendingRequestFieldsNotNull() {
		int result = 0;
		for (PendingReq p : PendingReqDaoImpl.getInstance().selectAllPendingRequests()) {
			if (p.getRequestAmount() == null || p.getRequestReason() == null) {
				result++;
			}
		}
		return result == 0 ? true: false;
	}
	
	public boolean resolvedRequestFieldsNotNull() {
		int result = 0;
		for (ResolvedReq r : ResolvedReqDaoImpl.getInstance().selectAllResolvedRequests()) {
			if (r.getResolvedStatus() == null || r.getResolvingManagerName() == null) {
				result++;
			}
		}
		return result == 0 ? true : false;
	}
	
	public boolean morePendingThanResolved() {
		int pending = PendingReqDaoImpl.getInstance().selectAllPendingRequests().size();
		int resolved = ResolvedReqDaoImpl.getInstance().selectAllResolvedRequests().size();
		return pending > resolved;
	}
}
