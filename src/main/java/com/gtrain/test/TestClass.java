package com.gtrain.test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtrain.dao.PendingReqDaoImpl;
import com.gtrain.model.Employee;
import com.gtrain.service.EmployeeService;
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
		

		Employee employee = EmployeeService.getInstance().getEmployee(new Employee.EmployeeBuilder().username("gtrainEmp").build());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(PendingReqDaoImpl.getInstance().selectAllByEmployee(employee)));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
