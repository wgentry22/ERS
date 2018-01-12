package com.gtrain.test;

import com.gtrain.dao.*;
import com.gtrain.model.*;
import com.gtrain.service.*;

public class TestClass {
	
	//Manager Dao Implementation Tested, working as intended

	public static void main(String[] args) {
		
//		DO NOT DELETE
//		FOR TESTING PURPOSES
//		Manager manager = new Manager();
//		manager.setUsername("admin");
//		manager.setPassword("admin");
//		manager.setFirstname("admin");
//		manager.setLastname("test");
//		

//		Employee employee = new Employee.EmployeeBuilder()
//				.username("gtrainEmp")
//				.password("gtrainnn")
//				.firstname("William")
//				.lastname("Gentry")
//				.email("william.gentry@test.com")
//				.address("1234 Broad Street")
//				.city("Suwanee")
//				.state("Georgia")
//				.zipcode("30024")
//				.build();
		
//		Employee demonstration = new Employee.EmployeeBuilder()
//				.username("demonstrationEmployee")
//				.password("gtrainnn")
//				.firstname("InClass")
//				.email("demonstration@test.com")
//				.lastname("Demonstration")
//				.address("456 Main Street")
//				.city("Madeupsville")
//				.state("Connecticut")
//				.zipcode("12345")
//				.build();
		
		
//		System.out.println(EmployeeService.getInstance().register(demonstration));

//		Employee employee = EmployeeService.getInstance().getEmployee(new Employee.EmployeeBuilder().username("demonstrationEmployee").build());

		
//		
//		PendingReq test = new PendingReq(28);
//		
//		PendingReq p = PendingReqDaoImpl.getInstance().select(test);
//		
//		Manager test2 = new Manager();
//		test2.setUsername("gtrainnn");
//		
//		Manager m = ManagerDaoImplementation.getInstance().select(test2);

		System.out.println("Selecting all Employees from DB");
		for (Employee e : EmployeeService.getInstance().getAllEmployees()) {
			System.out.println(e);
		}
		System.out.println("=====================================================");
		System.out.println("Selecting all Managers from DB");
		for (Manager m : ManagerDaoImplementation.getInstance().selectAll()) {
			System.out.println(m);
		}
		System.out.println("=====================================================");
		System.out.println("Selecting all Pending Requests from DB");
		for (PendingReq p : PendingRequestService.getInstance().selectAll()) {
			System.out.println(p);
		}
		System.out.println("=====================================================");
		System.out.println("Selecting all ResolvedRequests from DB");
		for (ResolvedReq r : ResolvedRequestService.getInstance().selectAll()) {
			System.out.println(r);
		}
		
		
		
	}

}
