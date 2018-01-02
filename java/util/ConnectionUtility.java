package com.gtrain.util;
import java.sql.Connection;
import java.sql.Statement;

import com.gtrain.model.Manager.MANAGER;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
public final class ConnectionUtility {

	
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:oracle:thin:@jta1712.cyxofh0hm1of.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "adminERS";
		String password = "jta1712";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	static void test() {
		try (Connection conn = ConnectionUtility.getConnection()) {
			System.out.println("Connection Achieved");
			String query = "Select * from manager";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			if (rs.next()) {
				System.out.println(rs.getString(MANAGER.USERNAME.ordinal()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test();
	}
}
