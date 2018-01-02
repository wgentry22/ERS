package com.gtrain.dao;
import java.util.List;
import com.gtrain.model.Manager;
public interface ManagerDao {

	public abstract boolean insert(Manager manager);
	public abstract boolean insertProcedure(Manager manager);
	public abstract Manager select(Manager manager);
	public abstract List<Manager> selectAll();
	public abstract int selectId(Manager manager);
	public abstract String getManagerHash(Manager manager);
	
}
