package com.gtrain.util;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public final class ConnectionUtility {

	
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:oracle:thin:@jta1712.cyxofh0hm1of.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "adminERS";
		String password = "jta1712";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	
}
