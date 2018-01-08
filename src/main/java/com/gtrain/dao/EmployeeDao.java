package com.gtrain.dao;
import com.gtrain.model.Employee;
import java.util.List;
public interface EmployeeDao {

	//Data from EMPLOYEE table

	public abstract boolean insertProcedure(Employee employee);
	public abstract boolean update(Employee employee);
	public abstract Employee select(Employee employee);
	public abstract List<Employee> selectAll();
	public abstract int selectId(Employee employee);
	public abstract String getEmployeeHash(Employee employee);
	
	
}
