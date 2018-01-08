package com.gtrain.dao;
import com.gtrain.model.ResolvedReq;
import com.gtrain.model.Employee;
import java.util.List;
public interface ResolvedReqDao {

	public abstract boolean insert(ResolvedReq resolved);
	public abstract boolean insertProcedure(ResolvedReq resolved);
	public abstract ResolvedReq select(ResolvedReq resolved);
	public abstract List<ResolvedReq> selectAll();
	public abstract List<ResolvedReq> selectAllByEmployee(Employee employee);
	
}
