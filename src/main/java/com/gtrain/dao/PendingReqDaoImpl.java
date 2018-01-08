package com.gtrain.dao;
import com.gtrain.model.Employee;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;

import com.gtrain.model.PendingReq;
import com.gtrain.model.PendingReq.PENDING;
import com.gtrain.util.ConnectionUtility;

public class PendingReqDaoImpl implements PendingReqDao {
	
	
	private static PendingReqDaoImpl pendingReqDaoImplementation;
	
	private PendingReqDaoImpl() {}
	
	public static PendingReqDaoImpl getInstance() {
		if (pendingReqDaoImplementation == null) {
			pendingReqDaoImplementation = new PendingReqDaoImpl();
		}
		return pendingReqDaoImplementation;
	}
	
	
	

	@Override
	public boolean insert(PendingReq pending) {

		try (Connection conn = ConnectionUtility.getConnection()) {
		
			int index = 0;
			
			String query = "insert into pending_request values (?, ?, ?, ?, ?)";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(++index, null); 	// Null because trigger will autoincrement id
			p.setInt(++index, pending.getRequestingEmployeeId());
			p.setString(++index, pending.getRequestAmount());
			p.setString(++index, pending.getRequestReason());
			p.setString(++index, null); 	// Null because trigger will automatically store and format date
											// that the pending request will make
			
			if (p.executeUpdate() > 0) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertProcedure(PendingReq pending) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			
			int index = 0;
			
			String query = "{CALL insert_pending_request(?, ?, ?)}";
			
			CallableStatement p = conn.prepareCall(query);
			
			p.setInt(++index, pending.getRequestingEmployeeId());
			p.setString(++index, pending.getRequestAmount());
			p.setString(++index, pending.getRequestReason());
			
			
			if (p.executeUpdate() > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		
		return false;
	}

	@Override
	public PendingReq select(PendingReq pending) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String query = "select * from pending_request where pend_req_id = ?";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setInt(++index, pending.getRequestId());
			
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				return new PendingReq(
						rs.getInt(PENDING.ID.ordinal()),
						rs.getInt(PENDING.EMPID.ordinal()),
						rs.getString(PENDING.AMOUNT.ordinal()),
						rs.getString(PENDING.REASON.ordinal()),
						rs.getString(PENDING.CREATED_AT.ordinal())
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public List<PendingReq> selectAll() {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "select * from pending_request order by e_id";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			ResultSet rs = p.executeQuery();
			
			List<PendingReq> pendingRequests = new ArrayList<PendingReq>();
			
			while (rs.next()) {
				pendingRequests.add(new PendingReq(
						rs.getInt(PENDING.ID.ordinal()),
						rs.getInt(PENDING.EMPID.ordinal()),
						rs.getString(PENDING.AMOUNT.ordinal()),
						rs.getString(PENDING.REASON.ordinal()),
						rs.getString(PENDING.CREATED_AT.ordinal())
						));
			}
			return pendingRequests;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	@Override
	public List<PendingReq> selectAllByEmployee(Employee employee) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			int index = 0;
			
			String query = "select * from pending_request where e_id = ?";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setInt(++index, employee.getId());
			
			ResultSet rs = p.executeQuery();
			
			List<PendingReq> pendingRequests = new ArrayList<PendingReq>();
			while (rs.next()) {
				pendingRequests.add(new PendingReq(
						rs.getInt(PENDING.ID.ordinal()),
						rs.getInt(PENDING.EMPID.ordinal()),
						rs.getString(PENDING.AMOUNT.ordinal()),
						rs.getString(PENDING.REASON.ordinal()),
						rs.getString(PENDING.CREATED_AT.ordinal())
						));
			}
			return pendingRequests;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	

}
