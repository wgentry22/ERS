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
		

//		Employee employee = EmployeeService.getInstance().getEmployee(new Employee.EmployeeBuilder().username("gtrainEmp").build());
//		
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			System.out.println(mapper.writeValueAsString(PendingReqDaoImpl.getInstance().selectAllByEmployee(employee)));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Employee employee = EmployeeService.getInstance().getEmployee(new Employee.EmployeeBuilder().username("gtrainEmp").build());
//		
//		PendingReq test = new PendingReq(28);
//		
//		PendingReq p = PendingReqDaoImpl.getInstance().select(test);
//		
//		Manager test2 = new Manager();
//		test2.setUsername("gtrainnn");
//		
//		Manager m = ManagerDaoImplementation.getInstance().select(test2);


		for (PendingReq p : PendingRequestService.getInstance().selectAll()) {
			System.out.println(p);
		}
		
		
//		for (ResolvedReq r : ResolvedRequestService.getInstance().selectAllByEmployee(employee)) {
//			System.out.println(r);
//		}
		
		
//		for (Manager m : ManagerDaoImplementation.getInstance().selectAll()) {
//			System.out.println(m);
//		}
		
	}

}
