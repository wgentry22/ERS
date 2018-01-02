package com.gtrain.dao;
import com.gtrain.model.PendingReq;
import com.gtrain.model.Employee;
import java.util.List;

public interface PendingReqDao {

	public abstract boolean insert(PendingReq pending);
	public abstract boolean insertProcedure(PendingReq pending);
	public abstract PendingReq select(PendingReq pending);
	public abstract List<PendingReq> selectAll();
	public abstract List<PendingReq> selectAllByEmployee(Employee employee);
	
	
}
