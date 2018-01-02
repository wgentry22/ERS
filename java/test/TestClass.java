package com.gtrain.test;
import com.gtrain.dao.EmployeeDaoImplementation;
import com.gtrain.model.Employee;
public class TestClass {

	public static void main(String[] args) {
		
		Employee emp = EmployeeDaoImplementation.getInstance().selectAll().get(0);
		System.out.println(EmployeeDaoImplementation.getInstance().selectId(emp));
		
		
	}

}
