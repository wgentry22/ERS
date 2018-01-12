package com.gtrain.JUnitTests;

import com.gtrain.dao.PendingReqDaoImpl;
import com.gtrain.dao.ResolvedReqDaoImpl;

public class RequestTests {

	public int pending() {
		return PendingReqDaoImpl.getInstance().selectAllPendingRequests().size();
	}
	
	public int resolved() {
		return ResolvedReqDaoImpl.getInstance().selectAllResolvedRequests().size();
	}
}
