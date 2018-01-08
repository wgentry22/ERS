package com.gtrain.ajax;

import com.gtrain.model.Manager;
import com.gtrain.service.ManagerService;



public class Role {
	public static boolean isManager(String username) {
		for (Manager m : ManagerService.getInstance().getAllManagers()) {
			if (m.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
}
