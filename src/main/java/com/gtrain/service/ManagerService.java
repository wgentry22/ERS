package com.gtrain.service;

import java.util.List;

import com.gtrain.model.Manager;
import com.gtrain.dao.ManagerDaoImplementation;

public class ManagerService {
	
	private static ManagerService managerService;
	
	private ManagerService() {}
	
	public static ManagerService getInstance() {
		if (managerService == null) {
			managerService = new ManagerService();
		}
		return managerService;
	}
	
	
	public Manager getManager(Manager manager) {
		return ManagerDaoImplementation.getInstance().select(manager);
	}
	
	public List<Manager> getAllManagers() {
		return ManagerDaoImplementation.getInstance().selectAll();
	}
	
	public Manager login(Manager manager) {
		Manager authorized = ManagerDaoImplementation.getInstance().select(manager);
		if (authorized.getPassword().equals(ManagerDaoImplementation.getInstance().getManagerHash(manager))) {
			return authorized;
		} else {
			return null;
		}
	}

}
