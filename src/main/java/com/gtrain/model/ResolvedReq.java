package com.gtrain.model;

public class ResolvedReq {

	private int resolvedRequestId;
	private int pendingRequestId;
	private int resolvingManagerId;
	private String resolvingManagerName;
	private String resolvingManagerFirstname;
	private String resolvingManagerLastname;
	private String resolvedStatus;
	private String timeRequestWasResolved;
	private String requestReason;
	private String requestAmount;
	private String timeRequestWasCreated;
	
	
	public ResolvedReq() {}
	
	public ResolvedReq(int pendingRequestId, int resolvingManagerId, String resolvedStatus) {
		this.pendingRequestId = pendingRequestId;
		this.resolvingManagerId = resolvingManagerId;
		this.resolvedStatus = resolvedStatus;
	}
	
	public ResolvedReq(int resId, int pendId, int mId, String mName, String resStatus, String timeResolved) {
		this.resolvedRequestId = resId;
		this.pendingRequestId = pendId;
		this.resolvingManagerId = mId;
		this.resolvingManagerName = mName;
		this.resolvedStatus = resStatus;
		this.timeRequestWasResolved = timeResolved;
	}
	
	public ResolvedReq(int resId, int pendId, int mId, String mName, String resStatus, String timeResolved, String requestReason, String requestAmount, String timeRequestWasCreated) {
		this.resolvedRequestId = resId;
		this.pendingRequestId = pendId;
		this.resolvingManagerId = mId;
		this.resolvingManagerName = mName;
		this.resolvedStatus = resStatus;
		this.timeRequestWasResolved = timeResolved;
		this.requestReason = requestReason;
		this.requestAmount = requestAmount;
		this.timeRequestWasCreated = timeRequestWasCreated;
	}
	
	public ResolvedReq(int resId, int pendId, int mId, String mFirstname, String mLastname, String resStatus, String timeResolved) {
		this.resolvedRequestId = resId;
		this.pendingRequestId = pendId;
		this.resolvingManagerId = mId;
		this.resolvingManagerFirstname = mFirstname;
		this.resolvingManagerLastname = mLastname;
		this.resolvedStatus = resStatus;
		this.timeRequestWasResolved = timeResolved;
	}
	
	
	public int getResolvedRequestId() {
		return resolvedRequestId;
	}

	public int getPendingRequestId() {
		return pendingRequestId;
	}

	public int getResolvingManagerId() {
		return resolvingManagerId;
	}

	public String getResolvingManagerName() {
		return resolvingManagerName;
	}

	
	
	public String getResolvingManagerFirstname() {
		return resolvingManagerFirstname;
	}


	public void setResolvingManagerFirstname(String resolvingManagerFirstname) {
		this.resolvingManagerFirstname = resolvingManagerFirstname;
	}


	public String getResolvingManagerLastname() {
		return resolvingManagerLastname;
	}


	public void setResolvingManagerLastname(String resolvingManagerLastname) {
		this.resolvingManagerLastname = resolvingManagerLastname;
	}


	public String getResolvedStatus() {
		return resolvedStatus;
	}

	public String getTimeRequestWasResolved() {
		return timeRequestWasResolved;
	}
	
	public String getRequestReason() {
		return requestReason;
	}

	public String getRequestAmount() {
		return requestAmount;
	}

	public String getTimeRequestWasCreated() {
		return timeRequestWasCreated;
	}

	@Override
	public String toString() {
		return "ResolvedReq [resolvingRequestId=" + resolvedRequestId + ", pendingRequestId=" + pendingRequestId
				+ ", resolvingManagerId=" + resolvingManagerId + ", resolvingManagerName=" + resolvingManagerName
				+ ", resolvedStatus=" + resolvedStatus + ", timeRequestWasResolved=" + timeRequestWasResolved + "]";
	}
	
	public enum RESOLVED {
		DUMMY, ID, PENDID, MANAGERID, MANAGERNAME, STATUS, RESOLVED_AT, REQUEST_REASON, REQUEST_AMOUNT, CREATED_AT;
	}
	
}
