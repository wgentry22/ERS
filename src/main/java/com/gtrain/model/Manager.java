package com.gtrain.model;

import java.io.Serializable;

public class Manager implements Serializable {

	private static final long serialVersionUID = 2234359375785277610L;
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	
	public Manager(int id) {
		super();
		this.id = id;
	}
	
	public Manager(String username) {
		this.username = username;
	}
	
	
	public Manager(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Manager(int id, String username, String password, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Manager() {
		this.firstname = "";
		this.lastname = "";
		this.username = "";
		this.password = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
	
	public enum MANAGER {
		Dummy, ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME;
		
	}
}
