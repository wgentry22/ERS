package com.gtrain.ajax;

public class AjaxMessage {
	private String message;
	
	public AjaxMessage(String msg) {
		this.message = msg;
	}
	
	public void setMessage(String s) {
		this.message = s;
	}
	
	public String getMessage() {
		return this.message;
	}

}
