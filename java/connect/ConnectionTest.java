package com.gtrain.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.gtrain.model.Manager.MANAGER;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionTest {

	static final String URL = "jdbc:oracle:thin:@jta1712.cyxofh0hm1of.us-east-2.rds.amazonaws.com:1521:ORCL";
	static final String USERNAME = "adminERS";
	static final String PASSWORD = "jta1712";
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		loadDrivers();
		testConnection(URL, USERNAME, PASSWORD);
	}

	// Step 1: Load the Drivers
	static void loadDrivers() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void testConnection(String url, String username, String password) {
		try {
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from manager");

			while (rs.next()) {
				System.out.println("Name: " + rs.getString(MANAGER.FIRSTNAME.ordinal()) + " " + rs.getString(MANAGER.LASTNAME.ordinal()));
				System.out.println("Username: " + rs.getString(MANAGER.USERNAME.ordinal()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
