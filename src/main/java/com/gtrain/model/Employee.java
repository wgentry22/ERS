package com.gtrain.model;

import java.io.Serializable;

public class Employee implements Serializable {


	private static final long serialVersionUID = -8335623434493624964L;
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	
	public Employee() {}
	
	
	
	
	public Employee(EmployeeBuilder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.password = builder.password;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.email = builder.email;
		this.address = builder.address;
		this.city = builder.city;
		this.state = builder.state;
		this.zipcode = builder.zipcode;
	}
	
	public static class EmployeeBuilder {
		private int id;
		private String username;
		private String password;
		private String firstname;
		private String lastname;
		private String email;
		private String address;
		private String city;
		private String state;
		private String zipcode;
		
		public EmployeeBuilder id(int i) {
			this.id = i;
			return this;
		}
		
		public EmployeeBuilder username(String s) {
			this.username = s;
			return this;
		}
		
		public EmployeeBuilder password(String s) {
			this.password = s;
			return this;
		}
		
		public EmployeeBuilder firstname(String s) {
			this.firstname = s;
			return this;
		}
		
		public EmployeeBuilder lastname (String s) {
			this.lastname = s;
			return this;
		}
		
		public EmployeeBuilder email (String s) {
			this.email = s;
			return this;
		}
		
		public EmployeeBuilder address(String s) {
			this.address = s;
			return this;
		}
		
		public EmployeeBuilder city(String s) {
			this.city = s;
			return this;
		}
		
		public EmployeeBuilder state(String s) {
			this.state = s;
			return this;
		}
		
		public EmployeeBuilder zipcode(String s) {
			this.zipcode = s;
			return this;
		}
		
		public Employee build() {
			return new Employee(this);
		}
	}
	
	


	public int getId() {
		return id;
	}




	public String getUsername() {
		return username;
	}




	public String getPassword() {
		return password;
	}




	public String getFirstname() {
		return firstname;
	}




	public String getLastname() {
		return lastname;
	}


	public String getFullname() {
		return firstname + " " + lastname;
	}


	public String getEmail() {
		return email;
	}




	public String getAddress() {
		return address;
	}




	public String getCity() {
		return city;
	}




	public String getState() {
		return state;
	}




	public String getZipcode() {
		return zipcode;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + "]";
	}


	// Values after password are from Employee Info Table
	// This is the order used after employee inner join employee_info on e_id = e_info_id;
	public enum EMPLOYEE {
		DUMMY, ID, USERNAME, PASSWORD, EI_ID, FIRSTNAME, LASTNAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE;
	}
	
}
