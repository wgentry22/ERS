package com.gtrain.ajax;

import com.gtrain.model.Employee;
import com.gtrain.model.Manager;
import com.gtrain.service.EmployeeService;
import com.gtrain.service.ManagerService;



public class Role {
	public static boolean isManager(String username) {
		boolean valid = false;
		for (Manager m : ManagerService.getInstance().getAllManagers()) {
			if (m.getUsername().equals(username)) {
				valid = true;
				break;
			}
		}
		return valid;
	}
	
	public static boolean isEmployee(String username) {
		boolean valid = false;
		for (Employee e : EmployeeService.getInstance().getAllEmployees()) {
			if (e.getUsername().equals(username)) {
				valid = true;
				break;
			}
		}
		return valid;
	}
	
}
