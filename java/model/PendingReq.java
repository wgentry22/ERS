package com.gtrain.model;

public class PendingReq {

	private int requestId;
	private int requestingEmployeeId;
	private String requestAmount;
	private String requestReason;
	private String timeRequestWasCreated;
	private String requestStatus;
	
	public PendingReq(int empId, String amount, String reason) {
		this.requestingEmployeeId = empId;
		this.requestAmount = amount;
		this.requestReason = reason;
	}
	
	public PendingReq(int reqId, int empId, String amount, String reason, String time) {
		this.requestId = reqId;
		this.requestingEmployeeId = empId;
		this.requestAmount = amount;
		this.requestReason = reason;
		this.timeRequestWasCreated = time;
		this.requestStatus = "Pending";
	}

	public int getRequestId() {
		return requestId;
	}

	public int getRequestingEmployeeId() {
		return requestingEmployeeId;
	}

	public String getRequestAmount() {
		return requestAmount;
	}

	public String getRequestReason() {
		return requestReason;
	}

	public String getTimeRequestWasCreated() {
		return timeRequestWasCreated;
	}
	
	public String getRequestStatus() {
		return this.requestStatus;
	}

	@Override
	public String toString() {
		return "PendingReq [requestId=" + requestId + ", requestingEmployeeId=" + requestingEmployeeId
				+ ", requestAmount=" + requestAmount + ", requestReason=" + requestReason + ", timeRequestWasCreated="
				+ timeRequestWasCreated + "]";
	}
	
	
	public enum PENDING {
		DUMMY, ID, EMPID, AMOUNT, REASON, CREATED_AT;
	}
}
