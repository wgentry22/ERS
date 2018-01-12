package com.gtrain.JUnitTests;


import com.gtrain.model.Employee;
import com.gtrain.model.Manager;
import com.gtrain.model.PendingReq;
import com.gtrain.model.ResolvedReq;
import com.gtrain.service.EmployeeService;
import com.gtrain.service.ManagerService;
import com.gtrain.service.PendingRequestService;
import com.gtrain.service.ResolvedRequestService;

public class JavaBeanFields {

	
	public boolean employeeInfoNull() {
		int result = 0;
		
		for (Employee e : EmployeeService.getInstance().getAllEmployees()) {
			if (e.getAddress() == null || e.getCity() == null || e.getState() == null || e.getZipcode() == null) {
				result++;
			}
		}
		
		return result > 0 ? false : true;
	}
	
	public boolean managerInfoNull() {
		int result = 0;
		
		for (Manager m : ManagerService.getInstance().getAllManagers()) {
			if (m.getFirstname() == null || m.getLastname() == null) {
				result++;
			}
		}
		
		return result > 0 ? false : true;
	}
	
	
	public boolean pendingInfoNull() {
		int result = 0;
		
		for (PendingReq p : PendingRequestService.getInstance().selectAll()) {
			if (p.getRequestReason() == null || p.getRequestAmount() == null || p.getTimeRequestWasCreated() == null) {
				result++;
			}
		}
		
		return result > 0 ? false : true;
	}
	
	public boolean resolvedInfoNull() {
		int result = 0;
		
		for (ResolvedReq r : ResolvedRequestService.getInstance().selectAll()) {
			if (r.getResolvingManagerName() == null || r.getTimeRequestWasResolved() ==  null || r.getResolvedStatus() == null) {
				result++;
			}
		}
		
		
		return result > 0 ? false : true;
	}
}
